package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbMarkExceptionDTO;
import com.geoway.webstore.entity.JctbMarkException;
import com.geoway.webstore.service.JctbMarkExceptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JctbMarkException)表控制层
 *
 * @author makejava
 * @since 2021-09-16 18:14:28
 */
@RestController
@RequestMapping("/jctbMarkException")
@ResponseResult
public class JctbMarkExceptionController {
    /**
     * 服务对象
     */
    @Resource
    private JctbMarkExceptionService jctbMarkExceptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public JctbMarkException selectOne(Long id) {
        return this.jctbMarkExceptionService.queryById(id);
    }

    @PutMapping
    public JctbMarkException update(@RequestBody JctbMarkException record) {
        return this.jctbMarkExceptionService.update(record);
    }

    @PutMapping("/batch")
    public int batchUpdate(@RequestBody List<JctbMarkException> records) {
        return this.jctbMarkExceptionService.batchUpdate(records);
    }

    public boolean deleteById(Long id) {
        return this.jctbMarkExceptionService.deleteById(id);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbMarkException> records) {
        return jctbMarkExceptionService.batchInsert(records);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbMarkExceptionService.deleteByTaskName(taskName);
    }

    @GetMapping("/{taskName}")
    public List<JctbMarkException> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbMarkExceptionService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbMarkExceptionDTO> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbMarkExceptionService.listByTaskName2(taskName);
    }
}