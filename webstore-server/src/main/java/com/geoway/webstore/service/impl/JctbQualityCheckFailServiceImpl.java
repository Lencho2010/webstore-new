package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbQualityCheckFailConverter;
import com.geoway.webstore.dao.JctbQualityCheckFailMapper;
import com.geoway.webstore.dto.JctbQualityCheckFailDto;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import com.geoway.webstore.service.JctbQualityCheckFailService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:34
 * @Description:
 */
@Service
public class JctbQualityCheckFailServiceImpl implements JctbQualityCheckFailService {
    @Resource
    JctbQualityCheckFailMapper jctbQualityCheckFailMapper;

    @Resource
    private IDWorker idWorker;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jctbQualityCheckFailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JctbQualityCheckFail record) {
        record.setId(idWorker.nextId());
        return jctbQualityCheckFailMapper.insert(record);
    }

    @Override
    public int insertSelective(JctbQualityCheckFail record) {
        return jctbQualityCheckFailMapper.insertSelective(record);
    }

    @Override
    public JctbQualityCheckFail selectByPrimaryKey(Long id) {
        return jctbQualityCheckFailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JctbQualityCheckFail record) {
        return jctbQualityCheckFailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JctbQualityCheckFail record) {
        return jctbQualityCheckFailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<JctbQualityCheckFail> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbQualityCheckFailMapper.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbQualityCheckFailMapper.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbQualityCheckFail> listByTaskName(String taskName) {
        return jctbQualityCheckFailMapper.listByTaskName(taskName);
    }

    @Override
    public List<JctbQualityCheckFailDto> listByTaskName2(String taskName) {
        List<JctbQualityCheckFail> overviews = jctbQualityCheckFailMapper.listByTaskName(taskName);
        List<JctbQualityCheckFailDto> dtoList = JctbQualityCheckFailConverter.Instance.domain2dto(overviews);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }
}
