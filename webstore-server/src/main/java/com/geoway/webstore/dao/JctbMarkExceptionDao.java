package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbMarkException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (JctbMarkException)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-16 18:14:28
 */
@Mapper
public interface JctbMarkExceptionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JctbMarkException queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JctbMarkException> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jctbMarkException 实例对象
     * @return 对象列表
     */
    List<JctbMarkException> queryAll(JctbMarkException jctbMarkException);

    /**
     * 新增数据
     *
     * @param jctbMarkException 实例对象
     * @return 影响行数
     */
    int insert(JctbMarkException jctbMarkException);

    /**
     * 修改数据
     *
     * @param jctbMarkException 实例对象
     * @return 影响行数
     */
    int update(JctbMarkException jctbMarkException);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    //int batchUpdate(@Param("records") List<JctbMarkException> records);

    int batchInsert(@Param("records") List<JctbMarkException> records);

    int deleteByTaskName(String taskName);

    List<JctbMarkException> listByTaskName(String taskName);

}