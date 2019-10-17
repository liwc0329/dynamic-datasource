package com.g7go.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr_Lee
 * @date 2019-10-17 10:16
 */
@ConfigurationProperties(prefix = "dynamic")
public class CustomDynamicDataSourceProperties {

    private Map<String, DataSourceConfig> datasource = new HashMap<String, DataSourceConfig>();

    public Map<String, DataSourceConfig> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourceConfig> datasource) {
        this.datasource = datasource;
    }
}
