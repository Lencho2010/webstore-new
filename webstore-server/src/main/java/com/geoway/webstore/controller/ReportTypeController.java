package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.ReportType;
import com.geoway.webstore.service.ReportTypeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * (ReportType)表控制层
 *
 * @author makejava
 * @since 2021-11-02 14:39:15
 */
@RestController
@RequestMapping("/reportType")
@ResponseResult
public class ReportTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ReportTypeService reportTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ReportType selectOne(Long id) {
        return this.reportTypeService.queryById(id);
    }

    @GetMapping("list")
    public List<ReportType> list() {
        return reportTypeService.queryAll();
    }

}