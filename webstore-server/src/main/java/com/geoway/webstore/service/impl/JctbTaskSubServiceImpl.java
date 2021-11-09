package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbTaskDetailConverter;
import com.geoway.webstore.converter.JctbTaskSubConverter;
import com.geoway.webstore.dao.JctbTaskDetailMapper;
import com.geoway.webstore.dao.JctbTaskSubMapper;
import com.geoway.webstore.dto.JctbTaskSubDto;
import com.geoway.webstore.entity.JctbTaskDetail;
import com.geoway.webstore.entity.JctbTaskSub;
import com.geoway.webstore.service.JctbTaskSubService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 17:42
 * @Description:
 */
@Service
public class JctbTaskSubServiceImpl implements JctbTaskSubService {
    @Resource
    JctbTaskSubMapper jctbTaskSubMapper;

    @Resource
    JctbTaskDetailMapper jctbTaskDetailMapper;

    @Resource
    private IDWorker idWorker;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jctbTaskSubMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbTaskSubMapper.deleteByTaskName(taskName);
    }

    @Override
    public int insert(JctbTaskSub record) {
        record.setId(idWorker.nextId());
        return jctbTaskSubMapper.insert(record);
    }

    @Override
    public int batchInsert(List<JctbTaskSub> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbTaskSubMapper.batchInsert(records);
    }

    @Override
    public int insertSelective(JctbTaskSub record) {
        record.setId(idWorker.nextId());
        return jctbTaskSubMapper.insertSelective(record);
    }

    @Override
    public JctbTaskSub selectByPrimaryKey(Long id) {
        return jctbTaskSubMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<JctbTaskSub> listByTaskName(String taskName) {
        return jctbTaskSubMapper.listByTaskName(taskName);
    }

    @Override
    public List<JctbTaskSubDto> listByTaskName2(String taskName) {
        List<JctbTaskSub> jctbTaskSubs = jctbTaskSubMapper.listByTaskName(taskName);

        List<JctbTaskDetail> jctbTaskDetails = jctbTaskDetailMapper.listByTaskName(taskName);
        //List<JctbTaskDetailDto> taskDetailDtoList = JctbTaskDetailConverter.Instance.domain2dto(jctbTaskDetails);
        List<JctbTaskSubDto> dtoList = JctbTaskSubConverter.Instance.domain2dto(jctbTaskSubs);
        dtoList.forEach(dto -> {
            List<JctbTaskDetail> collect = jctbTaskDetails.stream().filter(d -> d.getParentId().equals(dto.getId())).collect(Collectors.toList());
            dto.setChildren(JctbTaskDetailConverter.Instance.domain2dto(collect));
        });

        return dtoList;
    }

    @Override
    public int updateByPrimaryKeySelective(JctbTaskSub record) {
        return jctbTaskSubMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JctbTaskSub record) {
        return jctbTaskSubMapper.updateByPrimaryKey(record);
    }
}
