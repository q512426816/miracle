package com.crrcdt.pbd.register.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crrcdt.pbd.register.dao.RegisterMapper;
import com.crrcdt.pbd.register.pojo.RegisterInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterService extends ServiceImpl<RegisterMapper, RegisterInfo> {

    public RegisterInfo getOne(RegisterInfo info) {
        QueryWrapper<RegisterInfo> qw = new QueryWrapper<>();
        qw.setEntity(info);
        List<RegisterInfo> list = list(qw);
        return list.isEmpty() ? null : list.get(0);
    }
}
