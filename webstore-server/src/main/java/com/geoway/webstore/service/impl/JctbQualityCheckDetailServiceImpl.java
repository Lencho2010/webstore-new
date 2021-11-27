package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbQualityCheckDetailConverter;
import com.geoway.webstore.dao.JctbQualityCheckDetailMapper;
import com.geoway.webstore.dto.JctbQualityCheckDetailDTO;
import com.geoway.webstore.entity.JctbQualityCheckDetail;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import com.geoway.webstore.service.JctbQualityCheckDetailService;
import com.geoway.webstore.util.IDWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class JctbQualityCheckDetailServiceImpl implements JctbQualityCheckDetailService {
    @Resource
    JctbQualityCheckDetailMapper jctbQualityCheckDetailMapper;

    @Resource
    private IDWorker idWorker;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jctbQualityCheckDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JctbQualityCheckDetail record) {
        record.setId(idWorker.nextId());
        return jctbQualityCheckDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(JctbQualityCheckDetail record) {
        record.setId(idWorker.nextId());
        return jctbQualityCheckDetailMapper.insertSelective(record);
    }

    @Override
    public JctbQualityCheckDetail selectByPrimaryKey(Long id) {
        return jctbQualityCheckDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JctbQualityCheckDetail record) {
        return jctbQualityCheckDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<JctbQualityCheckDetail> records) {
        records.forEach(r->r.setId(idWorker.nextId()));
        return jctbQualityCheckDetailMapper.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbQualityCheckDetailMapper.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbQualityCheckDetail> listByTaskName(String taskName) {
        return jctbQualityCheckDetailMapper.listByTaskName(taskName);
    }

    @Override
    public List<JctbQualityCheckDetailDTO> listByTaskName2(String taskName) {
        List<JctbQualityCheckDetail> overviews = jctbQualityCheckDetailMapper.listByTaskName(taskName);
        List<JctbQualityCheckDetailDTO> dtoList = JctbQualityCheckDetailConverter.Instance.domain2dto(overviews);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }

    @Override
    public PageInfo pageByFilter(int page, int rows, JctbQualityCheckDetail entity) {
        PageHelper.startPage(page, rows);
        List<JctbQualityCheckDetail> list = jctbQualityCheckDetailMapper.findSelective(entity);
        PageInfo pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public List<JctbQualityCheckDetail> listByFilter(JctbQualityCheckDetail entity) {
        List<JctbQualityCheckDetail> list = jctbQualityCheckDetailMapper.findSelective(entity);

        return list;
    }


}
