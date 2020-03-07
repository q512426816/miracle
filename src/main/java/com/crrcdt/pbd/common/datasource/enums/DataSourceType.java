package com.crrcdt.pbd.common.datasource.enums;

public enum DataSourceType {
    /**
     * 主库  用于写操作
     */
    MASTER,

    /**
     * 从库1  用于读操作
     */
    SLAVE1,

    /**
     * 从库2  用于读操作
     */
    SLAVE2;
}