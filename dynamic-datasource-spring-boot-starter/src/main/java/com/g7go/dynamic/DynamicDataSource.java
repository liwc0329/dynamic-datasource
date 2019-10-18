package com.g7go.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * DynamicDataSourceContextHolder代码中使用setDataSourceType
 * 设置当前的数据源，在路由类中使用getDataSourceType进行获取，
 * 交给AbstractRoutingDataSource进行注入使用。
 *
 * @author lwc
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}