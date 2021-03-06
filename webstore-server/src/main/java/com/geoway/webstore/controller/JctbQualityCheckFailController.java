package com.geoway.webstore.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckFailDTO;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.geoway.webstore.service.JctbQualityCheckFailService;
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
 * @CreateTime: 2021/9/16 11:35
 * @Description:
 */
@RestController
@RequestMapping("/jctbQualityCheckFail")
@ResponseResult
public class JctbQualityCheckFailController {

    @Resource
    JctbQualityCheckFailService jctbQualityCheckFailService;

    @PostMapping
    public int insert(@RequestBody JctbQualityCheckFail record) {
        return jctbQualityCheckFailService.insert(record);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckFailService.deleteByTaskName(taskName);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbQualityCheckFail> records) {
        return jctbQualityCheckFailService.batchInsert(records);
    }

    @GetMapping("/{taskName}")
    public List<JctbQualityCheckFail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckFailService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbQualityCheckFailDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckFailService.listByTaskName2(taskName);
    }

    @PostMapping(value = {"/list/{page}/{rows}"})
    public PageInfo list(@PathVariable("page") int page,
                         @PathVariable("rows") int rows,
                         @RequestBody JctbQualityCheckFail entity) {
        return jctbQualityCheckFailService.pageByFilter(page, rows, entity);
    }

    @PostMapping("export")
    public void export(HttpServletResponse response, @RequestBody JctbQualityCheckFail entity) throws IOException {
        List<JctbQualityCheckFail> rows = jctbQualityCheckFailService.listByFilter(entity);

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
        writer.addHeaderAlias("ruleCode", "????????????");
        writer.addHeaderAlias("ruleName", "??????");
        writer.addHeaderAlias("tbbh", "????????????");
        writer.addHeaderAlias("finalResult", "????????????");
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
    public int updateByPrimaryKey(@RequestBody JctbQualityCheckFail record) {
        return jctbQualityCheckFailService.updateByPrimaryKey(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return jctbQualityCheckFailService.deleteByPrimaryKey(id);
    }


    public int insertSelective(JctbQualityCheckFail record) {
        return jctbQualityCheckFailService.insertSelective(record);
    }

    public JctbQualityCheckFail selectByPrimaryKey(Long id) {
        return jctbQualityCheckFailService.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(JctbQualityCheckFail record) {
        return jctbQualityCheckFailService.updateByPrimaryKeySelective(record);
    }
}
