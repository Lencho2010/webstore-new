package com.geoway.webstore.dao;

import com.geoway.webstore.entity.JctbUnzipDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JctbUnzipDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JctbUnzipDetail record);

    int insertSelective(JctbUnzipDetail record);

    JctbUnzipDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbUnzipDetail record);

    int updateByPrimaryKey(JctbUnzipDetail record);

    int batchInsert(@Param("records") List<JctbUnzipDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbUnzipDetail> listByTaskName(String taskName);

}