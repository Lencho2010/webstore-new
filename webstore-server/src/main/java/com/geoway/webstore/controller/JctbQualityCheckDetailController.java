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
        writer.addHeaderAlias("checkResult", "????????????");
        writer.addHeaderAlias("checkInfo", "????????????");
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
