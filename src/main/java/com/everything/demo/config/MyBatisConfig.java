package com.everything.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean
    SqlSessionFactory sqlSessionFactory(DataSource dataSource,
                                        @Value("classpath:mybatis-config.xml") Resource configLocation) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        return sqlSessionFactoryBean.getObject();
    }
}
