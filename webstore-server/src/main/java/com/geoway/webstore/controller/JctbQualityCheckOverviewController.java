package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckOverviewDto;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.geoway.webstore.service.JctbQualityCheckOverviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public List<JctbQualityCheckOverviewDto> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckOverviewService.listByTaskName2(taskName);
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
