package com.g7go.dynamic;

import java.lang.annotation.*;

/**
 * 自定义注解,数据源指定
 *
 * @author lwc
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}