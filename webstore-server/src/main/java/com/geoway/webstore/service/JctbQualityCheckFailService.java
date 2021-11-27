package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbQualityCheckFailDTO;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:34
 * @Description:
 */
public interface JctbQualityCheckFailService {

    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckFail record);

    int insertSelective(JctbQualityCheckFail record);

    JctbQualityCheckFail selectByPrimaryKey(Long id);

    int updateByPrimaryKey(JctbQualityCheckFail record);

    int updateByPrimaryKeySelective(JctbQualityCheckFail record);

    int batchInsert(@Param("records") List<JctbQualityCheckFail> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckFail> listByTaskName(String taskName);

    List<JctbQualityCheckFailDTO> listByTaskName2(String taskName);

    PageInfo pageByFilter(int page, int rows, JctbQualityCheckFail entity);

    List<JctbQualityCheckFail> listByFilter(JctbQualityCheckFail entity);
}
