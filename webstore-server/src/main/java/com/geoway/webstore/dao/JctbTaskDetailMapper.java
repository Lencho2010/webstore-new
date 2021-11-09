package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbTaskDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbTaskDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JctbTaskDetail record);

    int batchInsert(@Param("records") List<JctbTaskDetail> records);

    int insertSelective(JctbTaskDetail record);

    JctbTaskDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbTaskDetail record);

    int updateByPrimaryKey(JctbTaskDetail record);

    List<JctbTaskDetail> listByParentId(Long parentId);

    List<JctbTaskDetail> listByTaskName(String taskName);

    List<JctbTaskDetail> listByTaskNameAndStepCode(@Param("taskName") String taskName, @Param("stepCode") Integer stepCode);
}