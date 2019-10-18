package com.g7go.dynamic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * Order保证该AOP在@Transactional之前执行
 *
 * @author liwc
 */
@Aspect
@Order(-5)
public class DynamicDataSourceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        //获取当前的指定的数据源;
        String dsId = targetDataSource.value();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            LOG.warn("数据源 : {} 不存在，使用默认数据源", targetDataSource.value());
        } else {
            LOG.info("Use DataSource : {}", targetDataSource.value());
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        LOG.info("Revert DataSource : {} ", targetDataSource.value());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
