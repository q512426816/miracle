package com.crrcdt.pbd.register.controller;

import com.crrcdt.pbd.common.excel.ExportExcel;
import com.crrcdt.pbd.register.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 进出厂 控制层
 *
 * @author QINY
 */
@Slf4j
@Controller
@RequestMapping("/download")
public class DownloadController {

    private final DownloadService downloadService;

    @Autowired
    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @GetMapping("/excel/sign")
    public void excel(String dateStr, HttpServletResponse response) {
        log.info("导出签到信息excel请求,数据：dateStr={}", dateStr);
        try {
            if (dateStr == null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                dateStr = sdf.format(new Date());
            }
            ExportExcel ee = downloadService.signExcel(dateStr);
            ee.write(response, URLEncoder.encode("庞巴迪人员入厂信息" + dateStr, "UTF-8") + ".xlsx");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
