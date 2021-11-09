package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.ReportTemplate;
import com.geoway.webstore.service.ReportTemplateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReportTemplate)表控制层
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
@RestController
@RequestMapping("/reportTemplate")
@ResponseResult
public class ReportTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private ReportTemplateService reportTemplateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ReportTemplate selectOne(Long id) {
        return this.reportTemplateService.queryById(id);
    }

    @GetMapping(path = {"/list/{type}", "/list"})
    public List<ReportTemplate> listByType(@PathVariable(value = "type", required = false) String statisticType) {
        //if (statisticType == null) statisticType = "week";

        return reportTemplateService.listByType(statisticType);

    }

    @GetMapping("/listByCodes/{codes}")
    public List<ReportTemplate> listByCodes(@PathVariable("codes") List<String> codes) {
        return reportTemplateService.listByCodes(codes);
    }

}