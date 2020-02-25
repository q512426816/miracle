package com.crrcdt.pbd.register.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 进出厂 控制层
 *
 * @author QINY
 */
@Slf4j
@Controller
@RequestMapping("/download")
public class DownloadController {

    @GetMapping("/excel/sign")
    public void excel(HttpServletResponse response) {
        log.info("导出签到信息excel请求");
        
    }

}
