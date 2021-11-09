package com.geoway.webstore.service;

import com.geoway.webstore.entity.JctbTaskDetail;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 18:28
 * @Description:
 */
public interface JctbTaskDetailService {

    int deleteByPrimaryKey(Long id);

    int insert(JctbTaskDetail record);

    int batchInsert(List<JctbTaskDetail> records);

    int insertSelective(JctbTaskDetail record);

    JctbTaskDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbTaskDetail record);

    int updateByPrimaryKey(JctbTaskDetail record);

    List<JctbTaskDetail> listByParentId(Long parentId);

    List<JctbTaskDetail> listByTaskName(String taskName);

    List<JctbTaskDetail> listByTaskNameAndStepCode(String taskName, Integer stepCode);
}
