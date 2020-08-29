package org.hk.demo.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContext.class);

    private static final ThreadLocal<String> DATASOURCECONTEXT = new ThreadLocal<>();

    public static String getDataSource() {
        String dataSourceId = DATASOURCECONTEXT.get();
        LOGGER.debug("current datasource - [{}]", dataSourceId);
        return dataSourceId;
    }

    public static void setDataSource(String dataSourceId) {
        LOGGER.debug("switch to [{}] datasource", dataSourceId);
        DATASOURCECONTEXT.set(dataSourceId);
    }

    public static void clearDataSource() {
        LOGGER.debug("clear up datasource id");
        DATASOURCECONTEXT.remove();
    }
}
