package com.everything.demo.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        String dsId = targetDataSource.value();
        if (DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            // logger.info("Use DataSource : {} > {}", targetDataSource.value(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
        } else {
            logger.info("数据源[{}]不存在，使用默认数据源 > {}", targetDataSource.value(), point.getSignature());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // logger.info("Revert DataSource : {} > {}", targetDataSource.value(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
