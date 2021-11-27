package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbContrastDetailDTO;
import com.geoway.webstore.entity.JctbContrastDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (JctbContrastDetail)表服务接口
 *
 * @author makejava
 * @since 2021-09-16 14:24:41
 */
public interface JctbContrastDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JctbContrastDetail queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JctbContrastDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 实例对象
     */
    JctbContrastDetail insert(JctbContrastDetail jctbContrastDetail);

    /**
     * 修改数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 实例对象
     */
    JctbContrastDetail update(JctbContrastDetail jctbContrastDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int batchInsert(@Param("records") List<JctbContrastDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbContrastDetail> listByTaskName(String taskName);

    List<JctbContrastDetailDTO> listByTaskName2(String taskName);

}