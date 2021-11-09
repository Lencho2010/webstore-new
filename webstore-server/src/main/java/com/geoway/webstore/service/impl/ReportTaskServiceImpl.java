package com.geoway.webstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.geoway.webstore.config.DataSourceConfig;
import com.geoway.webstore.entity.*;
import com.geoway.webstore.dao.ReportTaskDao;
import com.geoway.webstore.response.BaseResponse;
import com.geoway.webstore.service.ReportTaskService;
import com.geoway.webstore.service.ReportTemplateService;
import com.geoway.webstore.service.ReportTypeService;
import com.geoway.webstore.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (ReportTask)表服务实现类
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
@Service("reportTaskService")
@Slf4j
public class ReportTaskServiceImpl implements ReportTaskService {

    @Resource
    private IDWorker idWorker;

    @Resource
    private ReportTaskDao reportTaskDao;

    @Resource
    private ThreadPoolTaskExecutor executor;

    @Resource
    private ReportTemplateService reportTemplateService;

    @Resource
    private DataSourceConfig dataSourceConfig;

    /*@Resource
    private JdbcTemplate jdbcTemplate;*/

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ReportTypeService reportTypeService;

    @Value("${report-export-path}")
    private String reportExportPath;

    @Value("${fr-report-export-url}")
    private String reportExportUrl;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReportTask queryById(Long id) {
        return this.reportTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ReportTask> queryAllByLimit(int offset, int limit) {
        return this.reportTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTask insert(ReportTask reportTask) {
        reportTask.setId(idWorker.nextId());
        reportTask.setCreateTime(new Date());
        if (reportTask.getStatus().equals(2)) {
            this.processExportTask(reportTask);
        }
        this.reportTaskDao.insert(reportTask);
        return reportTask;
    }

    /**
     * 修改数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTask update(ReportTask reportTask) {
        this.reportTaskDao.update(reportTask);
        return this.queryById(reportTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.reportTaskDao.deleteById(id) > 0;
    }

    @Override
    public PageInfo listByNameAndChargePerson(int page, int rows, String name, String chargePerson) {
        PageHelper.startPage(page, rows);
        ReportTask record = ReportTask.builder().chargePerson(chargePerson).name(name).build();
        List<ReportTask> list = reportTaskDao.queryAll(record);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<String> listChargePerson() {
        return this.reportTaskDao.listChargePerson();
    }

    @Override
    public ReportTask processExportTask(ReportTask reportTask) {
        ReportTask task = this.queryById(reportTask.getId());
        task.setStatus(2);
        task.setStartTime(new Date());
        this.reportTaskDao.update(task);

        //开始处理导出任务
        executor.execute(() -> doExecuteExportTask(task));
        return this.queryById(task.getId());
    }

    /**
     * 处理导出任务
     *
     * @param task
     */
    private void doExecuteExportTask(ReportTask task) {
        try {
            List<String> codeList = Arrays.asList(task.getExportDocs().split(","));
            List<ReportTemplate> reportTemplates = reportTemplateService.listByCodes(codeList);
            List<ReportTemplate> wordDocs = reportTemplates.stream().filter(t -> t.getDocType().equals("word")).collect(Collectors.toList());
            List<ReportTemplate> excelDocs = reportTemplates.stream().filter(t -> t.getDocType().equals("excel")).collect(Collectors.toList());

            doExecuteWord(task, wordDocs);
            doExecuteExcel(task, excelDocs);
            task.setStatus(1);
            task.setEndTime(new Date());
            task.setExportPath(this.gainOutDir(task));
            this.reportTaskDao.update(task);
        } catch (Exception ex) {
            task.setStatus(-1);
            task.setEndTime(new Date());
            this.reportTaskDao.update(task);
        }
    }

    /**
     * 导出word文档
     *
     * @param wordDocs
     */
    private void doExecuteWord(ReportTask task, List<ReportTemplate> wordDocs) {
        Map<String, Object> dataMap = new HashMap<>();
        String taskNames = task.getTaskNames();
        dataMap.put("taskNames", taskNames);

        wordDocs.forEach(item -> {
            String outFileDir = gainOutDir(task, item.getGroup());
            String xmlText = readFileToString(item.getUrl());
            JSONObject json = XmlUtil.xml2Json(xmlText);
            ExportWordConfigDetail configDetail = json.toJavaObject(ExportWordConfigDetail.class);
            transportSql(configDetail, dataMap);
            Map<String, Object> resultMap = processSql(configDetail);
            String outFileName = transportFileName(item.getName(), task.getFromDate(), task.getToDate());
            processWordTemplate(configDetail, resultMap, outFileName, outFileDir);
        });
    }

    /**
     * 统计报告报表导出的路径（reportPath/taskName/reportType/group）
     */
    private String gainOutDir(ReportTask task, String group) {
        ReportType reportType = reportTypeService.queryAll().stream().filter(t -> t.getType().equals(task.getStatisticType())).findAny().get();
        String outFilePath = String.format("%s/%s/%s/%s", reportExportPath, task.getName(), reportType.getName(), StringUtil.isEmpty(group) ? "" : group);
        File workDirFile = new File(outFilePath);
        if (!workDirFile.exists()) workDirFile.mkdirs();
        return outFilePath;
    }

    /**
     * 统计报告报表导出的路径（reportPath/taskName）
     */
    private String gainOutDir(ReportTask task) {
        String outFilePath = String.format("%s/%s", reportExportPath, task.getName());
        File workDirFile = new File(outFilePath);
        if (!workDirFile.exists()) workDirFile.mkdirs();
        return outFilePath;
    }

    //文件:关于2021年卫片执法下发数据情况的报告.docx -> 关于2021年卫片执法下发数据情况的报告(08月07日至11月05日).docx
    private String transportFileName(String fileName, Date fromDate, Date toDate) {
        String outFileName = fileName;
        String fileNameNoEx = FileUtil.getFileNameNoEx(outFileName);
        String extensionName = FileUtil.getExtensionName(outFileName);
        DateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        outFileName = String.format("%s(%s至%s).%s", fileNameNoEx, dateFormat.format(fromDate), dateFormat.format(toDate), extensionName);
        return outFileName;
    }

    private String readFileToString(String xmlPath) {
        File xmlFile = new File(xmlPath);
        if (!xmlFile.exists()) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    private void transportSql(ExportWordConfigDetail configDetail, Map<String, Object> dataMap) {
        TransportTemplate template = new TransportTemplate();

        configDetail.getSqlItem().forEach(item -> {
            template.setTemplate(item.getSql());
            template.setTemplateMap(dataMap);
            String transformSql = Transport.transform(template);
            item.setSql(transformSql);
        });
    }

    private Map<String, Object> processSql(ExportWordConfigDetail configDetail) {
        Map<String, Object> resultMap = new HashMap<>();
        configDetail.getSqlItem().forEach(item -> {
            String sql = item.getSql();
            Map<String, Object> map = dataSourceConfig.gainJdbcTemplate().queryForMap(sql);
            resultMap.put(item.getKey(), map);
        });
        return resultMap;
    }

    private void processWordTemplate(ExportWordConfigDetail configDetail, Map<String, Object> dataMap, String outFileName, String outFilePath) {
        File templateFile = new File(configDetail.getDocPath());
        String templatePath = templateFile.getParentFile().getAbsolutePath();// templateFile.getAbsolutePath();
        String templateName = templateFile.getName();
        try {
            ExportWordUtil.exportWord(dataMap, templatePath, templateName, outFilePath, outFileName);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private void doExecuteExcel(ReportTask task, List<ReportTemplate> excelDocs) {
        String exportUrl = reportExportUrl + "/report/export";
        excelDocs.forEach(item -> {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("taskNames", task.getTaskNames());
            dataMap.put("outFileDir", gainOutDir(task, item.getGroup()));
            dataMap.put("reportTemplateUrl", item.getUrl());
            dataMap.put("outputExcelPath", transportFileName(item.getName(), task.getFromDate(), task.getToDate()));
            BaseResponse response = restTemplate.postForObject(exportUrl, dataMap, BaseResponse.class);
            assert response != null;
            if (response.getCode() == 0) {
                log.error("报表生成失败：" + task.getName());
                log.error("--任务ID：" + task.getId());
                log.error("--错误信息：" + response.getMessage());
                throw new RuntimeException(response.getMessage());
            } else {
                log.info("报表生成成功：" + item.getName());
            }
        });
    }
}