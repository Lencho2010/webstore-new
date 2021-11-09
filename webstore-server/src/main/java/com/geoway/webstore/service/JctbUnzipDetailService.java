package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbUnzipDetailDto;
import com.geoway.webstore.entity.JctbUnzipDetail;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 9:41
 * @Description:
 */
public interface JctbUnzipDetailService {
    int deleteByPrimaryKey(Long id);

    int insert(JctbUnzipDetail record);

    int insertSelective(JctbUnzipDetail record);

    JctbUnzipDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JctbUnzipDetail record);

    int updateByPrimaryKey(JctbUnzipDetail record);

    int batchInsert(List<JctbUnzipDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbUnzipDetail> listByTaskName(String taskName);

    List<JctbUnzipDetailDto> listByTaskName2(String taskName);
}
