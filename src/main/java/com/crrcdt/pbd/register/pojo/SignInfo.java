package com.crrcdt.pbd.register.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName(value = "pbd_sign")
@Data
public final class SignInfo {
    /**
     * 入厂签到完成状态
     */
    public static final String STATUS_IN = "10";
    /**
     * 离厂签到完成状态
     */
    public static final String STATUS_OUT = "60";

    /**
     * 主键
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 通行信息表ID
     */
    @TableField("register_id")
    private Long registerId;

    /**
     * 入厂签到设备IP
     */
    @TableField("sign_in_ip")
    private String signInIp;

    /**
     * 入厂签到时间
     */
    @TableField("sign_in_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signInTime;

    /**
     * 入厂签到信息
     */
    @TableField("sign_in_info")
    private String signInInfo;


    /**
     * 离厂签到设备IP
     */
    @TableField("sign_out_ip")
    private String signOutIp;

    /**
     * 离厂签到时间
     */
    @TableField("sign_out_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signOutTime;

    /**
     * 离厂签到信息
     */
    @TableField("sign_out_info")
    private String signOutInfo;
    
    /**
     * 签到状态 10: 入厂签到完成   60： 离厂签到完成
     */
    @TableField("status")
    private String status;

}
