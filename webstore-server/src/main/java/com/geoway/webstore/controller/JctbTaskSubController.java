package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbTaskSubDTO;
import com.geoway.webstore.entity.JctbTaskSub;
import com.geoway.webstore.service.JctbTaskSubService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 17:46
 * @Description:
 */
@RestController
@RequestMapping("/jctbTaskSub")
@ResponseResult
public class JctbTaskSubController {

    @Resource
    JctbTaskSubService jctbTaskSubService;

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbTaskSubService.deleteByTaskName(taskName);
    }

    @PostMapping
    public int insert(@RequestBody JctbTaskSub record) {
        return jctbTaskSubService.insert(record);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbTaskSub> records) {
        return jctbTaskSubService.batchInsert(records);
    }

    @GetMapping("/{taskName}")
    public List<JctbTaskSub> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbTaskSubService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbTaskSubDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbTaskSubService.listByTaskName2(taskName);
    }

    @PutMapping
    public int updateByPrimaryKey(@RequestBody JctbTaskSub record) {
        return jctbTaskSubService.updateByPrimaryKey(record);
    }
}
