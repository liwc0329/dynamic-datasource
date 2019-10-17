package com.g7go.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Mr_Lee
 * @date 2019-10-17 14:23
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DynamicDataSourceAutoConfiguration.class})
public @interface EnableDynamicDataSource {
}
