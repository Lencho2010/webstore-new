package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbContrastDetailDto;
import com.geoway.webstore.entity.JctbContrastDetail;
import com.geoway.webstore.service.JctbContrastDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JctbContrastDetail)表控制层
 *
 * @author makejava
 * @since 2021-09-16 14:24:41
 */
@RestController
@RequestMapping("/jctbContrastDetail")
@ResponseResult
public class JctbContrastDetailController {

    @Resource
    private JctbContrastDetailService jctbContrastDetailService;

    @GetMapping("/selectOne")
    public JctbContrastDetail selectOne(Long id) {
        return this.jctbContrastDetailService.queryById(id);
    }

    @PutMapping
    public JctbContrastDetail update(@RequestBody JctbContrastDetail jctbContrastDetail) {
        return this.jctbContrastDetailService.update(jctbContrastDetail);
    }

    public boolean deleteById(Long id) {
        return this.jctbContrastDetailService.deleteById(id);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbContrastDetail> records) {
        return jctbContrastDetailService.batchInsert(records);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbContrastDetailService.deleteByTaskName(taskName);
    }

    @GetMapping("/{taskName}")
    public List<JctbContrastDetail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbContrastDetailService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbContrastDetailDto> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbContrastDetailService.listByTaskName2(taskName);
    }

}