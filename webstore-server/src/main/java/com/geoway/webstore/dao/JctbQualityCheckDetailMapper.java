package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbQualityCheckDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckDetail record);

    int insertSelective(JctbQualityCheckDetail record);

    JctbQualityCheckDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbQualityCheckDetail record);

    int updateByPrimaryKey(JctbQualityCheckDetail record);

    int batchInsert(@Param("records") List<JctbQualityCheckDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckDetail> listByTaskName(String taskName);

    List<JctbQualityCheckDetail> findSelective(JctbQualityCheckDetail entity);
}