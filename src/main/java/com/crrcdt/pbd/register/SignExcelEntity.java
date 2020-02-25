package com.crrcdt.pbd.register;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignExcelEntity implements Serializable {
    /**
     * 人员姓名
     */
    private String pName;

    /**
     * 人员部门
     */
    private String pDept;

    /**
     * 职工编号
     */
    private String pId;

    /**
     * 入厂时间
     */
    private String pTime;
    
    /**
     * 钉钉审批单号
     */
    private String dCode;
}
