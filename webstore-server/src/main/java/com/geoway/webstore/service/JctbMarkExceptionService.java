package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbMarkExceptionDTO;
import com.geoway.webstore.entity.JctbMarkException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (JctbMarkException)表服务接口
 *
 * @author makejava
 * @since 2021-09-16 18:14:28
 */
public interface JctbMarkExceptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JctbMarkException queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JctbMarkException> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jctbMarkException 实例对象
     * @return 实例对象
     */
    JctbMarkException insert(JctbMarkException jctbMarkException);

    /**
     * 修改数据
     *
     * @param jctbMarkException 实例对象
     * @return 实例对象
     */
    JctbMarkException update(JctbMarkException jctbMarkException);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int batchUpdate(List<JctbMarkException> jctbMarkExceptions);

    int batchInsert(@Param("records") List<JctbMarkException> records);

    int deleteByTaskName(String taskName);

    List<JctbMarkException> listByTaskName(String taskName);

    List<JctbMarkExceptionDTO> listByTaskName2(String taskName);
}