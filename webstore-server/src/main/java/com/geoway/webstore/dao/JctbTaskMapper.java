package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbTaskMapper {
    int deleteByPrimaryKey(String taskName);

    int insert(JctbTask record);

    int insertSelective(JctbTask record);

    JctbTask selectByPrimaryKey(String taskName);

    List<JctbTask> listByTaskNameAndStatus(@Param("taskName") String taskName, @Param("status") List<Integer> status);

    List<JctbTask> listByStatus(@Param("status") List<Integer> status);

    List<JctbTask> listByFilter(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("taskName") String taskName, @Param("status") List<Integer> status);

    int updateByPrimaryKeySelective(JctbTask record);

    int updateProgressByTaskName(JctbTask record);

    int updateStatusByTaskName(JctbTask record);

    int updateProgressAndStatusByTaskName(JctbTask record);

    int updateByPrimaryKey(JctbTask record);
}