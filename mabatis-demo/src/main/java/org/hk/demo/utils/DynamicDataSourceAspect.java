package org.hk.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hk.demo.annotation.DataSource;
import org.hk.demo.context.DataSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicDataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSource)")
    public void switchDataSource(JoinPoint joinPoint, DataSource dataSource) {
        DataSourceContext.setDataSource(dataSource.value());
    }

    @After("@annotation(dataSource)")
    public void restoreDataSource(JoinPoint joinPoint, DataSource dataSource) {
        LOGGER.debug("reset to default datasource");
        DataSourceContext.clearDataSource();
    }
}
