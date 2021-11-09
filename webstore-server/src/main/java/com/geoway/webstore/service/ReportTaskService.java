package com.geoway.webstore.service;

import com.geoway.webstore.entity.ReportTask;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (ReportTask)表服务接口
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
public interface ReportTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportTask queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ReportTask> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    ReportTask insert(ReportTask reportTask);

    /**
     * 修改数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    ReportTask update(ReportTask reportTask);

    ReportTask processExportTask(ReportTask reportTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    PageInfo listByNameAndChargePerson(int page, int rows, String name, String chargePerson);

    List<String> listChargePerson();

}