package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbContrastDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (JctbContrastDetail)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-16 14:21:19
 */
@Mapper
public interface JctbContrastDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JctbContrastDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JctbContrastDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jctbContrastDetail 实例对象
     * @return 对象列表
     */
    List<JctbContrastDetail> queryAll(JctbContrastDetail jctbContrastDetail);

    /**
     * 新增数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 影响行数
     */
    int insert(JctbContrastDetail jctbContrastDetail);

    /**
     * 修改数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 影响行数
     */
    int update(JctbContrastDetail jctbContrastDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int batchInsert(@Param("records") List<JctbContrastDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbContrastDetail> listByTaskName(String taskName);

}