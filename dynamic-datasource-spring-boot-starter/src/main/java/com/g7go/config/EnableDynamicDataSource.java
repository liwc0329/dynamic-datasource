package com.g7go.config;

import com.g7go.dynamic.DynamicDataSourceAspect;
import com.g7go.dynamic.DynamicDataSourceRegister;
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
@Import({DynamicDataSourceRegister.class, DynamicDataSourceAspect.class})
public @interface EnableDynamicDataSource {
}
