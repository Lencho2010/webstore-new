package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.ReportTask;
import com.geoway.webstore.service.ReportTaskService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.io.Console;
import java.util.List;

/**
 * (ReportTask)表控制层
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
@RestController
@RequestMapping("/reportTask")
@ResponseResult
public class ReportTaskController {
    /**
     * 服务对象
     */
    @Resource
    private ReportTaskService reportTaskService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ReportTask selectOne(Long id) {
        return this.reportTaskService.queryById(id);
    }

    @GetMapping("/{id}")
    public ReportTask selectById(@PathVariable Long id) {
        return this.reportTaskService.queryById(id);
    }

    @PostMapping
    public ReportTask insert(@RequestBody ReportTask record) {
        return this.reportTaskService.insert(record);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return reportTaskService.deleteById(id);
    }

    @PutMapping
    public ReportTask update(@RequestBody ReportTask record) {
        return reportTaskService.update(record);
    }

    //执行导出任务
    @PutMapping("/processExportTask")
    public ReportTask processExportTask(@RequestBody ReportTask record) {
        return reportTaskService.processExportTask(record);
    }

    @GetMapping(value = {"/list/{page}/{rows}"})
    public PageInfo list(@PathVariable("page") int page,
                         @PathVariable("rows") int rows,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "chargePerson", required = false) String chargePerson) {
        return reportTaskService.listByNameAndChargePerson(page, rows, name, chargePerson);
    }

    @GetMapping("listChargePerson")
    public List<String> listChargePerson() {
        return reportTaskService.listChargePerson();
    }

}