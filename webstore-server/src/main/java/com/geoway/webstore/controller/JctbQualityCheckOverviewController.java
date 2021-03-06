package com.geoway.webstore.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckOverviewDTO;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.geoway.webstore.service.JctbQualityCheckOverviewService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 10:38
 * @Description:
 */

@RestController
@RequestMapping("/jctbQualityCheckOverview")
@ResponseResult
public class JctbQualityCheckOverviewController {
    @Resource
    JctbQualityCheckOverviewService jctbQualityCheckOverviewService;

    @PostMapping
    public int insert(@RequestBody JctbQualityCheckOverview record) {
        return jctbQualityCheckOverviewService.insert(record);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckOverviewService.deleteByTaskName(taskName);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbQualityCheckOverview> records) {
        return jctbQualityCheckOverviewService.batchInsert(records);
    }

    @GetMapping("/{taskName}")
    public List<JctbQualityCheckOverview> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckOverviewService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbQualityCheckOverviewDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckOverviewService.listByTaskName2(taskName);
    }

    @PostMapping(value = {"/list/{page}/{rows}"})
    public PageInfo list(@PathVariable("page") int page,
                         @PathVariable("rows") int rows,
                         @RequestBody JctbQualityCheckOverview entity) {
        return jctbQualityCheckOverviewService.pageByFilter(page, rows, entity);
    }

    @PostMapping("export")
    public void export(HttpServletResponse response, @RequestBody JctbQualityCheckOverview entity) throws IOException {
        List<JctbQualityCheckOverview> rows = jctbQualityCheckOverviewService.listByFilter(entity);

        // ?????????????????????writer???????????????xls??????
        ExcelWriter writer = ExcelUtil.getWriter();

        //?????????????????????
        writer.addHeaderAlias("taskName", "??????");
        writer.addHeaderAlias("countyCode", "????????????");
        writer.addHeaderAlias("countyName", "????????????");
        writer.addHeaderAlias("cityCode", "????????????");
        writer.addHeaderAlias("cityName", "????????????");
        writer.addHeaderAlias("provinceCode", "????????????");
        writer.addHeaderAlias("provinceName", "????????????");
        writer.addHeaderAlias("status", "??????");
        writer.addHeaderAlias("info", "??????");
        writer.setOnlyAlias(true);
        // ???????????????????????????????????????????????????????????????
        writer.write(rows, true);
        //out???OutputStream??????????????????????????????

        //response???HttpServletResponse??????
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls??????????????????????????????????????????????????????????????????????????????
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("????????????", "UTF-8") + ".xls");
        // response.setHeader("Content-Disposition", "attachment;filename=JctbQualityCheckOverview.xls");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        // ??????writer???????????????
        writer.close();
        //????????????????????????Servlet???
        IoUtil.close(out);
    }

    @PutMapping
    public int updateByPrimaryKey(@RequestBody JctbQualityCheckOverview record) {
        return jctbQualityCheckOverviewService.updateByPrimaryKey(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return jctbQualityCheckOverviewService.deleteByPrimaryKey(id);
    }


    public int insertSelective(JctbQualityCheckOverview record) {
        return jctbQualityCheckOverviewService.insertSelective(record);
    }

    public JctbQualityCheckOverview selectByPrimaryKey(Long id) {
        return jctbQualityCheckOverviewService.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(JctbQualityCheckOverview record) {
        return jctbQualityCheckOverviewService.updateByPrimaryKeySelective(record);
    }

}
