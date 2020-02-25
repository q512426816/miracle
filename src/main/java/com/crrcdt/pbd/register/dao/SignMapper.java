package com.crrcdt.pbd.register.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crrcdt.pbd.register.pojo.SignInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignMapper extends BaseMapper<SignInfo> {
    
}
