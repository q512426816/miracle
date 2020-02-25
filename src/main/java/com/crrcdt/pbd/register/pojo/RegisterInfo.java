package com.crrcdt.pbd.register.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "pbd_register")
@Data
public final class RegisterInfo {
    /**
     * 主键
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 钉钉审批单号
     */
    @TableField("d_code")
    private String dCode;

    /**
     * 职工编号
     */
    @TableField("p_id")
    private String pId;

    /**
     * 人员名字
     */
    @TableField("p_name")
    private String pName;

    /**
     * 部门名字
     */
    @TableField("p_dept")
    private String pDept;

    /**
     * 性别
     */
    @TableField("p_gender")
    private String pGender;

    /**
     * 联系电话
     */
    @TableField("p_number")
    private String pNumber;

    /**
     * 家庭住址
     */
    @TableField("p_adrs")
    private String pAdrs;

    /**
     * 反厂交通工具
     */
    @TableField("p_trans")
    private String pTrans;

    /**
     * 反芜湖交通工具
     */
    @TableField("p_trans_wu")
    private String pTransWu;

    /**
     * 返回芜湖时间
     */
    @TableField("p_time")
    private String pTime;

    /**
     * 周围是否有疑似病例
     */
    @TableField("p_exist")
    private String pExist;

}
