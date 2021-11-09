package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbQualityCheckFailDto;
import com.geoway.webstore.entity.JctbQualityCheckFail;
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

    List<JctbQualityCheckFailDto> listByTaskName2(String taskName);
}
