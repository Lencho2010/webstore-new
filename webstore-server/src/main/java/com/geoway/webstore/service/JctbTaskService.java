package com.geoway.webstore.service;

import com.geoway.webstore.entity.JctbTask;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 15:15
 * @Description:
 */
public interface JctbTaskService {

    int deleteByTaskName(String taskName);

    int insert(JctbTask record);

    JctbTask selectByTaskName(String taskName);

    PageInfo listByTaskNameAndStatus(int page, int rows, String taskName, List<Integer> status);

    List<JctbTask> listByStatus(List<Integer> status);

    List<JctbTask> listByFilter(String fromDate, String toDate, String taskName, List<Integer> status);

    int updateProgressByTaskName(JctbTask record);

    int updateStatusByTaskName(JctbTask record);

    int updateProgressAndStatusByTaskName(JctbTask record);

    int updateByPrimaryKey(JctbTask record);
}
