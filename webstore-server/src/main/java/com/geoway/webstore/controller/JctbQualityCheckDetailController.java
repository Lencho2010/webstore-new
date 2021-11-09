package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckDetailDto;
import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.geoway.webstore.service.JctbQualityCheckDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public List<JctbQualityCheckDetailDto> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckDetailService.listByTaskName2(taskName);
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
