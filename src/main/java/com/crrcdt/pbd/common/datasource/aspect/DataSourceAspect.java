package com.crrcdt.pbd.common.datasource.aspect;

import com.crrcdt.pbd.common.datasource.DynamicDataSourceContextHolder;
import com.crrcdt.pbd.common.datasource.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(-1)
@Component
@Slf4j
public class DataSourceAspect {

    @Pointcut("@annotation(com.crrcdt.pbd.common.datasource.annotation.DataSource)")
    public void dsPointCut() {

    }

    @Before("dsPointCut()")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value());
        }
    }

    @After("dsPointCut()")
    public void after(JoinPoint point) {
        // 销毁数据源 在执行方法之后
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}