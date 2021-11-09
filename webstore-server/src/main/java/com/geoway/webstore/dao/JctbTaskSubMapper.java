package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbTaskSub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbTaskSubMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByTaskName(String taskName);

    int insert(JctbTaskSub record);

    int batchInsert(@Param("records") List<JctbTaskSub> records);

    int insertSelective(JctbTaskSub record);

    JctbTaskSub selectByPrimaryKey(Long id);

    List<JctbTaskSub> listByTaskName(String taskName);

    int updateByPrimaryKeySelective(JctbTaskSub record);

    int updateByPrimaryKey(JctbTaskSub record);

}