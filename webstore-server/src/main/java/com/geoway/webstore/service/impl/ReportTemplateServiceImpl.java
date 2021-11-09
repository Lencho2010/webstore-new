package com.geoway.webstore.service.impl;

import com.geoway.webstore.entity.ReportTemplate;
import com.geoway.webstore.dao.ReportTemplateDao;
import com.geoway.webstore.service.ReportTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReportTemplate)表服务实现类
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
@Service("reportTemplateService")
public class ReportTemplateServiceImpl implements ReportTemplateService {
    @Resource
    private ReportTemplateDao reportTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReportTemplate queryById(Long id) {
        return this.reportTemplateDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ReportTemplate> queryAllByLimit(int offset, int limit) {
        return this.reportTemplateDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<ReportTemplate> listByType(String statisticType) {
        return this.reportTemplateDao.listByType(statisticType);
    }

    @Override
    public List<ReportTemplate> listByCodes(List<String> codes) {
        return this.reportTemplateDao.listByCodes(codes);
    }

    /**
     * 新增数据
     *
     * @param reportTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTemplate insert(ReportTemplate reportTemplate) {
        this.reportTemplateDao.insert(reportTemplate);
        return reportTemplate;
    }

    /**
     * 修改数据
     *
     * @param reportTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTemplate update(ReportTemplate reportTemplate) {
        this.reportTemplateDao.update(reportTemplate);
        return this.queryById(reportTemplate.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.reportTemplateDao.deleteById(id) > 0;
    }
}