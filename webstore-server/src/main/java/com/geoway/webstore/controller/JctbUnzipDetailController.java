package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbUnzipDetailDTO;
import com.geoway.webstore.entity.JctbUnzipDetail;
import com.geoway.webstore.service.JctbUnzipDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 9:44
 * @Description:
 */
@RestController
@RequestMapping("/jctbUnzipDetail")
@ResponseResult
public class JctbUnzipDetailController {

    @Resource
    JctbUnzipDetailService jctbUnzipDetailService;

    @PostMapping
    public int insert(@RequestBody JctbUnzipDetail record) {
        return jctbUnzipDetailService.insert(record);
    }

    @PutMapping
    public int updateByPrimaryKey(@RequestBody JctbUnzipDetail record) {
        return jctbUnzipDetailService.updateByPrimaryKey(record);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbUnzipDetail> records) {
        return jctbUnzipDetailService.batchInsert(records);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbUnzipDetailService.deleteByTaskName(taskName);
    }

    @GetMapping("/{taskName}")
    public List<JctbUnzipDetail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbUnzipDetailService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbUnzipDetailDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbUnzipDetailService.listByTaskName2(taskName);
    }

    public int deleteByPrimaryKey(Long id) {
        return jctbUnzipDetailService.deleteByPrimaryKey(id);
    }

    public int insertSelective(JctbUnzipDetail record) {
        return jctbUnzipDetailService.insertSelective(record);
    }

    public JctbUnzipDetail selectByPrimaryKey(Long id) {
        return jctbUnzipDetailService.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(JctbUnzipDetail record) {
        return jctbUnzipDetailService.updateByPrimaryKeySelective(record);
    }
}
