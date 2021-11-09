package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.JctbTaskDetail;
import com.geoway.webstore.service.JctbTaskDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 18:31
 * @Description:
 */
@RestController
@RequestMapping("/jctbTaskDetail")
@ResponseResult
public class JctbTaskDetailController {

    @Resource
    JctbTaskDetailService jctbTaskDetailService;


    public int deleteByPrimaryKey(Long id) {
        return jctbTaskDetailService.deleteByPrimaryKey(id);
    }

    @PostMapping
    public int insert(@RequestBody JctbTaskDetail record) {
        return jctbTaskDetailService.insert(record);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbTaskDetail> records) {
        return jctbTaskDetailService.batchInsert(records);
    }

    public int insertSelective(JctbTaskDetail record) {
        return jctbTaskDetailService.insertSelective(record);
    }

    @GetMapping("/{id}")
    public JctbTaskDetail selectByPrimaryKey(@PathVariable("id") Long id) {
        return jctbTaskDetailService.selectByPrimaryKey(id);
    }

    @GetMapping("/listByParentId/{parentId}")
    public List<JctbTaskDetail> listByParentId(@PathVariable("parentId") Long parentId) {
        return jctbTaskDetailService.listByParentId(parentId);
    }

    /*@GetMapping("/listByTaskName/{taskName}")
    public List<JctbTaskDetail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbTaskDetailService.listByTaskName(taskName);
    }*/

    @GetMapping({"/listByTaskNameAndStepCode/{taskName}/{stepCode}", "/listByTaskName/{taskName}"})
    public List<JctbTaskDetail> listByTaskNameAndStepCode(@PathVariable("taskName") String taskName,
                                                          @PathVariable(value = "stepCode", required = false) Integer stepCode) {
        return jctbTaskDetailService.listByTaskNameAndStepCode(taskName, stepCode);
    }

    public int updateByPrimaryKeySelective(JctbTaskDetail record) {
        return jctbTaskDetailService.updateByPrimaryKeySelective(record);
    }

    @PutMapping
    public int updateByPrimaryKey(@RequestBody JctbTaskDetail record) {
        return jctbTaskDetailService.updateByPrimaryKey(record);
    }
}
