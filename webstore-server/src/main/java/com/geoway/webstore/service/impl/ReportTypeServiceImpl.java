package com.geoway.webstore.service.impl;

import com.geoway.webstore.entity.ReportType;
import com.geoway.webstore.dao.ReportTypeDao;
import com.geoway.webstore.service.ReportTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReportType)表服务实现类
 *
 * @author makejava
 * @since 2021-11-02 14:39:15
 */
@Service("reportTypeService")
public class ReportTypeServiceImpl implements ReportTypeService {
    @Resource
    private ReportTypeDao reportTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReportType queryById(Long id) {
        return this.reportTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ReportType> queryAllByLimit(int offset, int limit) {
        return this.reportTypeDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<ReportType> queryAll() {
        return this.reportTypeDao.queryAll(new ReportType());
    }


    /**
     * 新增数据
     *
     * @param reportType 实例对象
     * @return 实例对象
     */
    @Override
    public ReportType insert(ReportType reportType) {
        this.reportTypeDao.insert(reportType);
        return reportType;
    }

    /**
     * 修改数据
     *
     * @param reportType 实例对象
     * @return 实例对象
     */
    @Override
    public ReportType update(ReportType reportType) {
        this.reportTypeDao.update(reportType);
        return this.queryById(reportType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.reportTypeDao.deleteById(id) > 0;
    }
}