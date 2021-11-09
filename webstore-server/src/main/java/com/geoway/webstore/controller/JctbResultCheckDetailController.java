package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.JctbResultCheckDetailDto;
import com.geoway.webstore.entity.JctbResultCheckDetail;
import com.geoway.webstore.service.JctbResultCheckDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JctbResultCheckDetail)表控制层
 *
 * @author makejava
 * @since 2021-09-16 17:22:55
 */
@RestController
@RequestMapping("/jctbResultCheckDetail")
@ResponseResult
public class JctbResultCheckDetailController {
    /**
     * 服务对象
     */
    @Resource
    private JctbResultCheckDetailService jctbResultCheckDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public JctbResultCheckDetail selectOne(Long id) {
        return this.jctbResultCheckDetailService.queryById(id);
    }

    @PutMapping
    public JctbResultCheckDetail update(@RequestBody JctbResultCheckDetail jctbResultCheckDetail) {
        return this.jctbResultCheckDetailService.update(jctbResultCheckDetail);
    }

    public boolean deleteById(Long id) {
        return this.jctbResultCheckDetailService.deleteById(id);
    }

    @PostMapping("/batch")
    public int batchInsert(@RequestBody List<JctbResultCheckDetail> records) {
        return jctbResultCheckDetailService.batchInsert(records);
    }

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbResultCheckDetailService.deleteByTaskName(taskName);
    }

    @GetMapping("/{taskName}")
    public List<JctbResultCheckDetail> listByTaskName(@PathVariable("taskName") String taskName) {
        return jctbResultCheckDetailService.listByTaskName(taskName);
    }

    @GetMapping("/list/{taskName}")
    public List<JctbResultCheckDetailDto> listByTaskName2(@PathVariable("taskName") String taskName) {
        return jctbResultCheckDetailService.listByTaskName2(taskName);
    }
}