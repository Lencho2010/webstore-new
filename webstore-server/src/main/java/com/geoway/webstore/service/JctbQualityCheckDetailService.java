package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbQualityCheckDetailDTO;
import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:33
 * @Description:
 */
public interface JctbQualityCheckDetailService {

    int deleteByPrimaryKey(Long id);

    int insert(JctbQualityCheckDetail record);

    int insertSelective(JctbQualityCheckDetail record);

    JctbQualityCheckDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKey(JctbQualityCheckDetail record);

    int updateByPrimaryKeySelective(JctbQualityCheckDetail record);

    int batchInsert(@Param("records") List<JctbQualityCheckDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbQualityCheckDetail> listByTaskName(String taskName);

    List<JctbQualityCheckDetailDTO> listByTaskName2(String taskName);

    PageInfo pageByFilter(int page, int rows, JctbQualityCheckDetail entity);

    List<JctbQualityCheckDetail> listByFilter(JctbQualityCheckDetail entity);
}
