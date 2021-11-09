package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbUnzipDetailConverter;
import com.geoway.webstore.dao.JctbUnzipDetailMapper;
import com.geoway.webstore.dto.JctbUnzipDetailDto;
import com.geoway.webstore.entity.JctbUnzipDetail;
import com.geoway.webstore.service.JctbUnzipDetailService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 9:41
 * @Description:
 */
@Service
public class JctbUnzipDetailServiceImpl implements JctbUnzipDetailService {
    @Resource
    JctbUnzipDetailMapper jctbUnzipDetailMapper;

    @Resource
    private IDWorker idWorker;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jctbUnzipDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JctbUnzipDetail record) {
        record.setId(idWorker.nextId());
        return jctbUnzipDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(JctbUnzipDetail record) {
        record.setId(idWorker.nextId());
        return jctbUnzipDetailMapper.insertSelective(record);
    }

    @Override
    public JctbUnzipDetail selectByPrimaryKey(Long id) {
        return jctbUnzipDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JctbUnzipDetail record) {
        return jctbUnzipDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JctbUnzipDetail record) {
        return jctbUnzipDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<JctbUnzipDetail> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbUnzipDetailMapper.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbUnzipDetailMapper.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbUnzipDetail> listByTaskName(String taskName) {
        return jctbUnzipDetailMapper.listByTaskName(taskName);
    }

    @Override
    public List<JctbUnzipDetailDto> listByTaskName2(String taskName) {
        List<JctbUnzipDetail> jctbUnzipDetails = jctbUnzipDetailMapper.listByTaskName(taskName);
        List<JctbUnzipDetailDto> dtoList = JctbUnzipDetailConverter.Instance.domain2dto(jctbUnzipDetails);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }
}
