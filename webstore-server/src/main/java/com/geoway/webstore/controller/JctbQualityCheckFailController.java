package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbQualityCheckFailDto;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.service.JctbQualityCheckFailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public List<JctbQualityCheckFailDto> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbQualityCheckFailService.listByTaskName2(taskName);
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
