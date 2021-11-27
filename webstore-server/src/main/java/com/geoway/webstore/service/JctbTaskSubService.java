package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbTaskSubDTO;
import com.geoway.webstore.entity.JctbTaskSub;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 17:42
 * @Description:
 */
public interface JctbTaskSubService {

    int deleteByPrimaryKey(Long id);

    int deleteByTaskName(String taskName);

    int insert(JctbTaskSub record);

    int batchInsert(List<JctbTaskSub> records);

    int insertSelective(JctbTaskSub record);

    JctbTaskSub selectByPrimaryKey(Long id);

    List<JctbTaskSub> listByTaskName(String taskName);

    List<JctbTaskSubDTO> listByTaskName2(String taskName);

    int updateByPrimaryKeySelective(JctbTaskSub record);

    int updateByPrimaryKey(JctbTaskSub record);
}
