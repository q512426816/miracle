package com.crrcdt.pbd.register.service;

import com.crrcdt.pbd.common.excel.ExportExcel;
import com.crrcdt.pbd.register.SignExcelEntity;
import com.crrcdt.pbd.register.dao.DownloadMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DownloadService {

    @Autowired
    private DownloadMapper downloadMapper;

    public ExportExcel signExcel(String dateStr) {
        Map<String, Object> map = new HashMap<>();
        map.put("dateStr", dateStr);
        List<SignExcelEntity> signExcelList = downloadMapper.findList(map);
        List<String> headerList = new ArrayList<>();
        headerList.add("序号");
        headerList.add("部门名称");
        headerList.add("姓名");
        headerList.add("职工编号");
        headerList.add("入厂时间");
        headerList.add("钉钉审批单号");
        ExportExcel ee = new ExportExcel("人员入厂信息" + dateStr, headerList);
        //正式内容第一行
        int rownumber = 1;
        for (SignExcelEntity excelEntity : signExcelList) {
            Row row = ee.addRow();
            int i = 0;
            ee.addCell(row, i++, rownumber++);
            ee.addCell(row, i++, excelEntity.getPDept());
            ee.addCell(row, i++, excelEntity.getPName());
            ee.addCell(row, i++, excelEntity.getPId());
            ee.addCell(row, i++, excelEntity.getPTime());
            ee.addCell(row, i, excelEntity.getDCode());
        }
        return ee;
    }
}
