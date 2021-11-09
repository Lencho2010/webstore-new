package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbQualityCheckOverviewDto;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 10:32
 * @Description:
 */
public interface JctbQualityCheckOverviewService {

    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckOverview record);

    int insertSelective(JctbQualityCheckOverview record);

    JctbQualityCheckOverview selectByPrimaryKey(Long id);

    int updateByPrimaryKey(JctbQualityCheckOverview record);

    int updateByPrimaryKeySelective(JctbQualityCheckOverview record);

    int batchInsert(@Param("records") List<JctbQualityCheckOverview> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckOverview> listByTaskName(String taskName);

    List<JctbQualityCheckOverviewDto> listByTaskName2(String taskName);
}
