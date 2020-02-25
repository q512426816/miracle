package com.crrcdt.pbd.register.controller;

import com.crrcdt.pbd.common.utils.WebUtils;
import com.crrcdt.pbd.register.pojo.RegisterInfo;
import com.crrcdt.pbd.register.service.InOrOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 进出厂 控制层
 *
 * @author QINY
 */
@Slf4j
@RestController
@RequestMapping("/register")
public class SignController {

    private final InOrOutService service;

    @Autowired
    public SignController(InOrOutService service) {
        this.service = service;
    }

    @GetMapping("/inorout")
    public String inOrOut(RegisterInfo info, HttpServletRequest request) {
        log.info("签到信息：{}", info);
        if (info == null) {
            return "签到失败！数据无效";
        }
        // 获取客户端真实IP地址
        String ipAdre = WebUtils.getIp(request);
        String str = "";
        try {
            str = service.inOrOut(info, ipAdre);
        } catch (Exception e) {
            str = "<div style='font-size:50px;color:red;'>" + e.getMessage() + "</div>";
            log.error(e.getMessage(), e);
        }
        return "<div style='font-size:50px;'>" + str + "</div>";
    }


    @GetMapping("/excel/")
    public String excel(RegisterInfo info, HttpServletRequest request) {
        log.info("签到信息：{}", info);
        if (info == null) {
            return "签到失败！数据无效";
        }
        // 获取客户端真实IP地址
        String ipAdre = WebUtils.getIp(request);
        String str = "";
        try {
            str = service.inOrOut(info, ipAdre);
        } catch (Exception e) {
            str = "<div style='font-size:50px;color:red;'>" + e.getMessage() + "</div>";
            log.error(e.getMessage(), e);
        }
        return "<div style='font-size:50px;'>" + str + "</div>";
    }

}
