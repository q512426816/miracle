package com.crrcdt.pbd.register.dao;

import com.crrcdt.pbd.register.pojo.SignExcelEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DownloadMapper {

    List<SignExcelEntity> findList(Map<String, Object> map);

}
