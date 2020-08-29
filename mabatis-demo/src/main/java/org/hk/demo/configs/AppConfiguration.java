package org.hk.demo.configs;

import org.hk.demo.Application;
import org.hk.demo.utils.DynamicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    DataSourceConfiguration dsc;

    @Bean(name = "createDataSource")
    @DependsOn("dataSourceConfiguration")
    public Map<Object, Object> createDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        List<String> aliases = dsc.getAlias();
        if (null == aliases || 0 == aliases.size()) {
            LOGGER.error("datasource configuration is empty.");
            return null;
        }
        for (int i = 0; i < aliases.size(); i++) {
            dataSourceMap.put(aliases.get(i), DataSourceBuilder.create().driverClassName(dsc.getDriverClassName().get(i)).url(dsc.getUrl().get(i)).username(dsc.getUsername().get(i)).password(dsc.getPassword().get(i)).build());
        }
        return dataSourceMap;
    }

    @Bean
    @Primary
    @DependsOn("createDataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(createDataSource());
        dynamicDataSource.setDefaultTargetDataSource(createDataSource().get("masterdb"));
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
