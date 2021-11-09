package com.geoway.webstore.service;

import com.geoway.webstore.entity.ReportType;
import java.util.List;

/**
 * (ReportType)表服务接口
 *
 * @author makejava
 * @since 2021-11-02 14:39:15
 */
public interface ReportTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReportType> queryAllByLimit(int offset, int limit);

    List<ReportType> queryAll();

    /**
     * 新增数据
     *
     * @param reportType 实例对象
     * @return 实例对象
     */
    ReportType insert(ReportType reportType);

    /**
     * 修改数据
     *
     * @param reportType 实例对象
     * @return 实例对象
     */
    ReportType update(ReportType reportType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}