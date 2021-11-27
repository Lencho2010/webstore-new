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

        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();

        //自定义标题别名
        writer.addHeaderAlias("taskName", "批次");
        writer.addHeaderAlias("countyCode", "区县代码");
        writer.addHeaderAlias("countyName", "区县名称");
        writer.addHeaderAlias("cityCode", "地市代码");
        writer.addHeaderAlias("cityName", "地市名称");
        writer.addHeaderAlias("provinceCode", "省级代码");
        writer.addHeaderAlias("provinceName", "省级名称");
        writer.addHeaderAlias("ruleCode", "规则代码");
        writer.addHeaderAlias("ruleName", "规则");
        writer.addHeaderAlias("tbbh", "图斑编号");
        writer.addHeaderAlias("finalResult", "结果信息");
        writer.setOnlyAlias(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("质检概览", "UTF-8") + ".xls");
        // response.setHeader("Content-Disposition", "attachment;filename=JctbQualityCheckOverview.xls");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
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
