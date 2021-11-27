package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbQualityCheckOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbQualityCheckOverviewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckOverview record);

    int insertSelective(JctbQualityCheckOverview record);

    JctbQualityCheckOverview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbQualityCheckOverview record);

    int updateByPrimaryKey(JctbQualityCheckOverview record);

    int batchInsert(@Param("records") List<JctbQualityCheckOverview> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckOverview> listByTaskName(String taskName);

    List<JctbQualityCheckOverview> findSelective(JctbQualityCheckOverview entity);
}