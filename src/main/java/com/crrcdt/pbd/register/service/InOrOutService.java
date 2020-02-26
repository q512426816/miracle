package com.crrcdt.pbd.register.service;

import com.crrcdt.pbd.common.utils.DateUtils;
import com.crrcdt.pbd.register.pojo.RegisterInfo;
import com.crrcdt.pbd.register.pojo.SignInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class InOrOutService {

    private final RegisterService registerService;
    private final SignService signService;

    @Autowired
    public InOrOutService(RegisterService registerService, SignService signService) {
        this.registerService = registerService;
        this.signService = signService;
    }

    public synchronized String inOrOut(RegisterInfo info, String ip) {
        if (info == null || info.getDCode() == null) {
            return "<div style='color:red;'>二维码内容缺失！</div>";
        }
        // 1. 查询是否存在内容一致的通行信息
        RegisterInfo register = registerService.getOne(info);
        if (register != null) {
            // 2. 若存在，则进行全部的签到信息查询
            List<SignInfo> allList = signService.allListByRegisterId(register.getId());
            if (!allList.isEmpty()) {
                // 2.2 若查询到 判断是否在今日之内签到过
                for (SignInfo signInfo : allList) {
                    Date signInDate = signInfo.getSignInTime();
                    if (DateUtils.isSameDate(signInDate, new Date())) {
                        // 2.2.1 若是在今日之内签到过 则直接返回告知短时间内不可重复扫码
                        String dateStr = DateUtils.getDateStrTime(signInDate);
                        return "已扫码，时间：" + dateStr + "<br/>扫码信息：" + signInfo + "<br/>通行信息：" + register;
                    }
                }
            }
            // 2.1 若没查询到签到信息，则进行入厂签到信息插入
            signService.signInByRegister(register, ip);
            return "操作成功！当前状态为：【入厂】<br/>通行证信息：" + register;
        } else {
            // 3. 若不存在，则插入一条记录，自动生成id，紧跟着插入一条入厂签到信息
            registerService.save(info);
            signService.signInByRegister(info, ip);
            return "操作成功！当前状态为：【入厂】<br/>通行证信息：" + info;
        }

    }
}
