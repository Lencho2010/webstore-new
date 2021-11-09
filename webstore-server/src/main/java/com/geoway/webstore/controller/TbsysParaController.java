package com.geoway.webstore.controller;

import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.config.TbsysParaConfig;
import com.geoway.webstore.service.TbsysParaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Lencho
 * @create 2021-09-09 9:21
 * @desc
 */
@RestController
@RequestMapping("/sysPara")
@ResponseResult
public class TbsysParaController {

    @Resource
    TbsysParaService tbsysParaService;

    @Resource
    TbsysParaConfig tbsysParaConfig;

//    String scanIntervalKey = "aadea8a9-b7ad-44e2-a7a4-6d37ae432742";// tbsysParaConfig.getScanIntervalKey();
//    String serviceStatusKey = "add77e71-6603-4dd7-9ff9-6e2a947c398e";//  tbsysParaConfig.getServiceStatusKey();
//    String scanPathKey = "eefc68d6-50d0-46ee-ae60-f7556941e92c";//  tbsysParaConfig.getScanPathKey();
//    String scanPathsKey = "a10519d2-85f3-4b06-b38a-2df9c6462623";//  tbsysParaConfig.getScanPathsKey();

    @GetMapping("/serviceStatus")
    public String findServiceStatus() {
        return tbsysParaService.findOne(tbsysParaConfig.getServiceStatusKey()).getValue();
    }

    @PutMapping("/serviceStatus/{status}")
    public boolean updateServiceStatus(@PathVariable("status") String status) {
        return tbsysParaService.update(tbsysParaConfig.getServiceStatusKey(), status);
    }

    @GetMapping("/scanPaths")
    public String findScanPaths() {
        return tbsysParaService.findOne(tbsysParaConfig.getScanPathsKey()).getValue();
    }

    @GetMapping("/scanPath")
    public String findScanPath() {
        return tbsysParaService.findOne(tbsysParaConfig.getScanPathKey()).getValue();
    }

    @PutMapping("/scanPath")
    public boolean updateScanPath(@RequestParam("scanPath") String scanPath) {
        return tbsysParaService.update(tbsysParaConfig.getScanPathKey(), scanPath);
    }

    @GetMapping("/scanInterval")
    public String findScanInterval() {
        return tbsysParaService.findOne(tbsysParaConfig.getScanIntervalKey()).getValue();
    }

    @PutMapping("/scanInterval/{scanInterval}")
    public boolean updateScanInterval(@PathVariable("scanInterval") String scanInterval) {
        return tbsysParaService.update(tbsysParaConfig.getScanIntervalKey(), scanInterval);
    }
}
