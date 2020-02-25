package com.crrcdt.pbd.register.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crrcdt.pbd.register.pojo.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper extends BaseMapper<RegisterInfo> {
    
}
