package com.everything.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
    private static final String TYPE = "type";
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String SPRING_DATASOURCE = "spring.datasource.";
    private static final String CUSTOM_DATASOURCE = "application.datasource.";
    private static final String NAMES = "names";

    private DataSource defaultDataSource;
    private Map<String, DataSource> customDataSources = new HashMap<>();

    @Override
    public void setEnvironment(Environment env) {
        logger.info("DynamicDataSourceRegister.setEnvironment()");
        initDefaultDataSource(env);
        initCustomDataSources(env);
    }

    private void initDefaultDataSource(Environment env) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, SPRING_DATASOURCE);
        Map<String, Object> dsMap = propertyResolver.getSubProperties(null);

        defaultDataSource = buildDataSource(dsMap);
        dataBinder(defaultDataSource, dsMap);
    }

    private void initCustomDataSources(Environment env) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, CUSTOM_DATASOURCE);
        String names = propertyResolver.getProperty(NAMES);

        for (String dsPrefix : names.split(",")) {
            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
            DataSource dataSource = buildDataSource(dsMap);
            customDataSources.put(dsPrefix, dataSource);
            dataBinder(dataSource, dsMap);
        }
    }

    @SuppressWarnings("unchecked")
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        Object value = dsMap.get(TYPE);
        if (value == null) {
            value = DATASOURCE_TYPE_DEFAULT;
        }

        try {
            Class<? extends DataSource> type = (Class<? extends DataSource>) Class.forName((String) value);
            String driverClassName = (String) dsMap.get(DRIVER_CLASS_NAME);
            String url = (String) dsMap.get(URL);
            String username = (String) dsMap.get(USERNAME);
            String password = (String) dsMap.get(PASSWORD);

            return DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(type).build();
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    private void dataBinder(DataSource dataSource, Map<String, Object> dsMap) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(new DefaultConversionService());
        dataBinder.setIgnoreNestedProperties(false);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreUnknownFields(true);

        Map<String, Object> values = new HashMap<>(dsMap);
        values.remove(TYPE);
        values.remove(DRIVER_CLASS_NAME);
        values.remove(URL);
        values.remove(USERNAME);
        values.remove(PASSWORD);
        dataBinder.bind(new MutablePropertyValues(values));
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        logger.info("DynamicDataSourceRegister.registerBeanDefinitions()");
        Map<Object, Object> targetDataSources = new HashMap<>();

        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");

        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }
}
