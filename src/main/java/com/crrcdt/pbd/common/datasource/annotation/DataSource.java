package com.crrcdt.pbd.common.datasource.annotation;

import com.crrcdt.pbd.common.datasource.enums.DataSourceType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    DataSourceType value() default DataSourceType.MASTER;
}