package com.g7go.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Mr_Lee
 * @date 2019-10-17 11:15
 */
//@Component
//@Configuration
//@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties(value = {
        CustomDynamicDataSourceProperties.class,
        DefaultDynamicDataSourceProperties.class
})
public class DynamicDataSourceAutoConfiguration {
}
