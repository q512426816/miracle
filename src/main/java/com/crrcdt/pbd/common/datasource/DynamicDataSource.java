package com.crrcdt.pbd.common.datasource;

import com.crrcdt.pbd.common.datasource.enums.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(Map<Object, Object> targetDataSources) {
        if (targetDataSources == null || targetDataSources.isEmpty()) {
            throw new RuntimeException("动态配置数据源，源列表不能为空！");
        }
        DataSource defaultTargetDataSource = (DataSource) targetDataSources.get(DataSourceType.MASTER.name());
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        // afterPropertiesSet()方法调用时用来将targetDataSources的属性写入resolvedDataSources中的
        super.afterPropertiesSet();
    }

    /**
     * 根据Key获取数据源的信息
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}