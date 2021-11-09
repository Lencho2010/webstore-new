package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.JctbTask;
import com.geoway.webstore.service.JctbTaskService;
import com.geoway.webstore.util.ExportWordUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 15:29
 * @Description:
 */
@RestController
@RequestMapping("/jctbTask")
@ResponseResult
public class JctbTaskController {

    @Resource
    JctbTaskService jctbTaskService;

    @DeleteMapping("/{taskName}")
    public int deleteByTaskName(@PathVariable("taskName") String taskName) {
        return jctbTaskService.deleteByTaskName(taskName);
    }

    @PostMapping("")
    public int insert(@RequestBody JctbTask record) {
        return jctbTaskService.insert(record);
    }

    @GetMapping("/{taskName}")
    public JctbTask selectByTaskName(@PathVariable("taskName") String taskName) {
        return jctbTaskService.selectByTaskName(taskName);
    }

    @GetMapping(value = {"/listByFilter"})
    public List<JctbTask> listByFilter(@RequestParam("fromDate") String fromDate,
                                       @RequestParam("toDate") String toDate,
                                       @RequestParam(value = "taskName", required = false) String taskName,
                                       @RequestParam(value = "status", required = false) List<Integer> status) {
        return jctbTaskService.listByFilter(fromDate, toDate, taskName, status);
    }

    @ApiOperation(value = "分页查询任务列表", notes = "分页查询任务列表")
    @GetMapping(value = {"/list/{page}/{rows}"})
    public PageInfo list(@PathVariable("page") int page,
                         @PathVariable("rows") int rows,
                         @RequestParam(value = "taskName", required = false) String taskName,
                         @RequestParam(value = "status", required = false) List<Integer> status) {
        return jctbTaskService.listByTaskNameAndStatus(page, rows, taskName, status);
    }

    @GetMapping("/listByStatus")
    public List<JctbTask> listByStatus(@RequestParam(value = "status", required = false) List<Integer> status) {
        return jctbTaskService.listByStatus(status);
    }

    @PutMapping("/updateProgress")
    public int updateProgressByTaskName(@RequestBody JctbTask record) {
        return jctbTaskService.updateProgressByTaskName(record);
    }

    @PutMapping("/updateStatus")
    public int updateStatusByTaskName(@RequestBody JctbTask record) {
        return jctbTaskService.updateStatusByTaskName(record);
    }

    @PutMapping("/updateProgressAndStatus")
    public int updateProgressAndStatusByTaskName(@RequestBody JctbTask record) {
        return jctbTaskService.updateProgressAndStatusByTaskName(record);
    }

    @PutMapping
    public int updateByPrimaryKey(@RequestBody JctbTask record) {
        return jctbTaskService.updateByPrimaryKey(record);
    }

    @GetMapping("/testExportWord")
    public int testExportWord() {
        ExportWordUtil.test();
        return 1;
    }
}
