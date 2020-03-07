package com.crrcdt.pbd.common.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.crrcdt.pbd.common.datasource.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({MybatisPlusProperties.class})
@Slf4j
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build(env, "spring.datasource.druid.");
    }

    @Bean(name = "slave1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSource slave1DataSource() {
        return DruidDataSourceBuilder.create().build(env, "spring.datasource.druid.");
    }

    @Bean(name = "slave2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DruidDataSourceBuilder.create().build(env, "spring.datasource.druid.");
    }

    @Bean(name = "dynamicDataSource")
    @DependsOn({"masterDataSource"})
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new LinkedHashMap<>(3);
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE1.name(), slave1DataSource());
        targetDataSources.put(DataSourceType.SLAVE2.name(), slave2DataSource());
        return new DynamicDataSource(targetDataSources);
    }

}