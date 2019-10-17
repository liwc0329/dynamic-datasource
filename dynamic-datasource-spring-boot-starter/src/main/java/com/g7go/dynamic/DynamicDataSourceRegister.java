package com.g7go.dynamic;

import com.g7go.config.CustomDynamicDataSourceProperties;
import com.g7go.config.DataSourceConfig;
import com.g7go.config.DefaultDynamicDataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源注册
 *
 * @author lwc
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    private CustomDynamicDataSourceProperties customDynamicDataSourceProperties;

    private DefaultDynamicDataSourceProperties defaultDynamicDataSourceProperties;

    private Environment environment;

    private static final String DATASOURCE_TYPE_DEFAULT = "com.zaxxer.hikari.HikariDataSource";

    /**
     * 默认数据源
     */
    private DataSource defaultDataSource;

    /**
     * 自定义数据源
     */
    private Map<String, DataSource> customDataSources = new HashMap<>();


    public DynamicDataSourceRegister(DefaultDynamicDataSourceProperties defaultDynamicDataSourceProperties, CustomDynamicDataSourceProperties customDynamicDataSourceProperties) {
        this.customDynamicDataSourceProperties = customDynamicDataSourceProperties;
        this.defaultDynamicDataSourceProperties = defaultDynamicDataSourceProperties;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 加载主数据源配置.
     */
    private void initDefaultDataSource() {
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", defaultDynamicDataSourceProperties.getType());
        dsMap.put("driverClassName", defaultDynamicDataSourceProperties.getDriverClassName());
        dsMap.put("url", defaultDynamicDataSourceProperties.getUrl());
        dsMap.put("username", defaultDynamicDataSourceProperties.getUsername());
        dsMap.put("password", defaultDynamicDataSourceProperties.getPassword());
        defaultDataSource = dataBinder(buildDataSource(dsMap));
    }

    /**
     * 初始化更多数据源
     */
    private void initCustomDataSources() {
        Map<String, DataSourceConfig> datasource = customDynamicDataSourceProperties.getDatasource();
        datasource.forEach((x, y) -> {
            Map<String, Object> dsMap = new HashMap<>();
            dsMap.put("driverClassName", y.getDriverClassName());
            dsMap.put("url", y.getUrl());
            dsMap.put("username", y.getUsername());
            dsMap.put("password", y.getPassword());
            dsMap.put("type", defaultDynamicDataSourceProperties.getType());
            customDataSources.put(x, dataBinder(buildDataSource(dsMap)));
        });
    }

    /**
     * 创建datasource
     */
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type = dsMap.get("type");
        if (type == null) {
            type = DATASOURCE_TYPE_DEFAULT;
        }
        try {
            Class<? extends DataSource> dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dsMap.get("driverClassName").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 为DataSource绑定更多数据
     */
    private DataSource dataBinder(DataSource dataSource) {
        return Binder.get(environment).bind("spring.datasource", Bindable.of(dataSource.getClass())).get();
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        LOG.info("注册数据源: DynamicDataSourceRegister.registerBeanDefinitions()");
        Map<Object, Object> targetDataSources = new HashMap<>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        DynamicDataSourceContextHolder.dataSourceIds.addAll(customDataSources.keySet());
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        //添加属性：AbstractRoutingDataSource.defaultTargetDataSource
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }
}
