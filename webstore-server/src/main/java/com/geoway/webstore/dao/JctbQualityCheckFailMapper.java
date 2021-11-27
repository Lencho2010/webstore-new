package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbQualityCheckFailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckFail record);

    int insertSelective(JctbQualityCheckFail record);

    JctbQualityCheckFail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbQualityCheckFail record);

    int updateByPrimaryKey(JctbQualityCheckFail record);

    int batchInsert(@Param("records") List<JctbQualityCheckFail> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckFail> listByTaskName(String taskName);

    List<JctbQualityCheckFail> findSelective(JctbQualityCheckFail entity);
}