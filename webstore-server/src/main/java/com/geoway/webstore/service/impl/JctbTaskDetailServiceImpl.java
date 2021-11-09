package com.geoway.webstore.service.impl;

import com.geoway.webstore.dao.JctbTaskDetailMapper;
import com.geoway.webstore.entity.JctbTaskDetail;
import com.geoway.webstore.service.JctbTaskDetailService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 18:29
 * @Description:
 */
@Service
public class JctbTaskDetailServiceImpl implements JctbTaskDetailService {

    @Resource
    JctbTaskDetailMapper jctbTaskDetailMapper;

    @Resource
    private IDWorker idWorker;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jctbTaskDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JctbTaskDetail record) {
        record.setId(idWorker.nextId());
        return jctbTaskDetailMapper.insert(record);
    }

    @Override
    public int batchInsert(List<JctbTaskDetail> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbTaskDetailMapper.batchInsert(records);
    }

    @Override
    public int insertSelective(JctbTaskDetail record) {
        record.setId(idWorker.nextId());
        return jctbTaskDetailMapper.insertSelective(record);
    }

    @Override
    public JctbTaskDetail selectByPrimaryKey(Long id) {
        return jctbTaskDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JctbTaskDetail record) {
        return jctbTaskDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JctbTaskDetail record) {
        return jctbTaskDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<JctbTaskDetail> listByParentId(Long parentId) {
        return jctbTaskDetailMapper.listByParentId(parentId);
    }

    @Override
    public List<JctbTaskDetail> listByTaskName(String taskName) {
        return jctbTaskDetailMapper.listByTaskName(taskName);
    }

    @Override
    public List<JctbTaskDetail> listByTaskNameAndStepCode(String taskName, Integer stepCode) {
        return jctbTaskDetailMapper.listByTaskNameAndStepCode(taskName, stepCode);
    }
}
