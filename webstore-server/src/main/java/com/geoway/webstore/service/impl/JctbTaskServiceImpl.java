package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbTaskConverter;
import com.geoway.webstore.dao.JctbTaskMapper;
import com.geoway.webstore.dto.JctbTaskDto;
import com.geoway.webstore.entity.JctbTask;
import com.geoway.webstore.service.JctbTaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 15:25
 * @Description:
 */
@Service
public class JctbTaskServiceImpl implements JctbTaskService {

    @Resource
    JctbTaskMapper jctbTaskMapper;

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbTaskMapper.deleteByPrimaryKey(taskName);
    }

    @Override
    public int insert(JctbTask record) {
        return jctbTaskMapper.insert(record);
    }

    @Override
    public JctbTask selectByTaskName(String taskName) {
        return jctbTaskMapper.selectByPrimaryKey(taskName);
    }

    @Override
    public PageInfo listByTaskNameAndStatus(int page, int rows, String taskName, List<Integer> status) {
        PageHelper.startPage(page, rows);
        List<JctbTask> list = jctbTaskMapper.listByTaskNameAndStatus(taskName, status);
        PageInfo pageInfo = new PageInfo<>(list);
        List taskList = pageInfo.getList();
        List<JctbTaskDto> dtoList = JctbTaskConverter.Instance.domain2dto(taskList);
        IntStream.range(0, dtoList.size()).forEach(i -> {
                    JctbTaskDto dto = dtoList.get(i);
                    dto.setIndex((page - 1) * rows + 1 + i);
                }
        );
        pageInfo.setList(dtoList);
        return pageInfo;
    }

    @Override
    public List<JctbTask> listByStatus(List<Integer> status) {
        return jctbTaskMapper.listByStatus(status);
    }

    @Override
    public List<JctbTask> listByFilter(String fromDate, String toDate, String taskName, List<Integer> status) {
        return jctbTaskMapper.listByFilter(fromDate, toDate, taskName, status);
    }

    @Override
    public int updateProgressByTaskName(JctbTask record) {
        return jctbTaskMapper.updateProgressByTaskName(record);
    }

    @Override
    public int updateStatusByTaskName(JctbTask record) {
        return jctbTaskMapper.updateStatusByTaskName(record);
    }

    @Override
    public int updateProgressAndStatusByTaskName(JctbTask record) {
        return jctbTaskMapper.updateProgressAndStatusByTaskName(record);
    }

    @Override
    public int updateByPrimaryKey(JctbTask record) {
        return jctbTaskMapper.updateByPrimaryKey(record);
    }
}
