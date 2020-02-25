package com.crrcdt.pbd.register.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crrcdt.pbd.register.dao.SignMapper;
import com.crrcdt.pbd.register.pojo.RegisterInfo;
import com.crrcdt.pbd.register.pojo.SignInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SignService extends ServiceImpl<SignMapper, SignInfo> {

    public void signInByRegister(RegisterInfo register, String ip) {
        if (register == null || register.getId() == null) {
            throw new RuntimeException("通行信息有误，签到失败！");
        }
        SignInfo sign = new SignInfo();
        sign.setRegisterId(register.getId());
        sign.setSignInIp(ip);
        sign.setSignInTime(new Date());
        sign.setStatus(SignInfo.STATUS_IN);
        super.baseMapper.insert(sign);
    }

    public List<SignInfo> unLeaveListByRegisterId(Long registerId) {
        SignInfo sign = new SignInfo();
        sign.setRegisterId(registerId);
        sign.setStatus(SignInfo.STATUS_IN);
        QueryWrapper<SignInfo> qw = new QueryWrapper<>();
        qw.setEntity(sign);
        return list(qw);
    }

    public void signOut(SignInfo sign, String ip) {
        if (sign == null || sign.getId() == null) {
            throw new RuntimeException("离厂操作失败！数据不完整！");
        }
        sign.setSignOutIp(ip);
        sign.setStatus(SignInfo.STATUS_OUT);
        sign.setSignOutTime(new Date());
        updateById(sign);
    }

    public List<SignInfo> allListByRegisterId(Long registerId) {
        SignInfo sign = new SignInfo();
        sign.setRegisterId(registerId);
        QueryWrapper<SignInfo> qw = new QueryWrapper<>();
        qw.setEntity(sign);
        qw.orderByDesc("sign_in_time");
        return list(qw);
    }
}
