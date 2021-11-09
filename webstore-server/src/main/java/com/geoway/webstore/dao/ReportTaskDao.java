package com.geoway.webstore.dao;

import com.geoway.webstore.entity.ReportTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ReportTask)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
@Mapper
public interface ReportTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportTask queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReportTask> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reportTask 实例对象
     * @return 对象列表
     */
    List<ReportTask> queryAll(ReportTask reportTask);

    /**
     * 新增数据
     *
     * @param reportTask 实例对象
     * @return 影响行数
     */
    int insert(ReportTask reportTask);

    /**
     * 修改数据
     *
     * @param reportTask 实例对象
     * @return 影响行数
     */
    int update(ReportTask reportTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<String> listChargePerson();

}