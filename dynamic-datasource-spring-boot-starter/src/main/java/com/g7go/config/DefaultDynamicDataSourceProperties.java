package com.g7go.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 如果是一下数据库连接池提供的数据源spring-boot将自动配置
 * 当然也可以手动配置
 * "org.apache.tomcat.jdbc.pool.DataSource",
 * "com.zaxxer.hikari.HikariDataSource",
 * "org.apache.commons.dbcp.BasicDataSource", // deprecated
 * "org.apache.commons.dbcp2.BasicDataSource"
 */
@ConfigurationProperties(prefix = "spring.datasource")
public class DefaultDynamicDataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Class type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
