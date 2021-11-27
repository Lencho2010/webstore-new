package com.geoway.webstore.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckDetailDTO;
import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.geoway.webstore.service.JctbQualityCheckDetailService;
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
@RequestMapping("/jctbQualityCheckDetail")
@ResponseResult
public class JctbQualityCheckDetailController {

    @Resource
    JctbQualityCheckDetailService jctbQualityCheckDetailService;

    @PostMapping
    public int insert(@RequestBody JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailService.insert(record);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckDetailService.deleteByTaskName(taskName);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbQualityCheckDetail> records) {
        return jctbQualityCheckDetailService.batchInsert(records);
    }

    @GetMapping("/{taskName}")
    public List<JctbQualityCheckDetail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckDetailService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbQualityCheckDetailDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckDetailService.listByTaskName2(taskName);
    }

    @PostMapping(value = {"/list/{page}/{rows}"})
    public PageInfo list(@PathVariable("page") int page,
                         @PathVariable("rows") int rows,
                         @RequestBody JctbQualityCheckDetail entity) {
        return jctbQualityCheckDetailService.pageByFilter(page, rows, entity);
    }

    @PostMapping("export")
    public void export(HttpServletResponse response, @RequestBody JctbQualityCheckDetail entity) throws IOException {
        List<JctbQualityCheckDetail> rows = jctbQualityCheckDetailService.listByFilter(entity);

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
        writer.addHeaderAlias("checkResult", "质检结果");
        writer.addHeaderAlias("checkInfo", "质检信息");
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
    public int updateByPrimaryKey(@RequestBody JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailService.updateByPrimaryKey(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return jctbQualityCheckDetailService.deleteByPrimaryKey(id);
    }


    public int insertSelective(JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailService.insertSelective(record);
    }

    public JctbQualityCheckDetail selectByPrimaryKey(Long id) {
        return jctbQualityCheckDetailService.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailService.updateByPrimaryKeySelective(record);
    }
}
