package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbResultCheckDetailConverter;
import com.geoway.webstore.dto.JctbResultCheckDetailDto;
import com.geoway.webstore.entity.JctbResultCheckDetail;
import com.geoway.webstore.dao.JctbResultCheckDetailDao;
import com.geoway.webstore.service.JctbResultCheckDetailService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (JctbResultCheckDetail)表服务实现类
 *
 * @author makejava
 * @since 2021-09-16 17:22:55
 */
@Service("jctbResultCheckDetailService")
public class JctbResultCheckDetailServiceImpl implements JctbResultCheckDetailService {
    @Resource
    private JctbResultCheckDetailDao jctbResultCheckDetailDao;

    @Resource
    private IDWorker idWorker;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JctbResultCheckDetail queryById(Long id) {
        return this.jctbResultCheckDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<JctbResultCheckDetail> queryAllByLimit(int offset, int limit) {
        return this.jctbResultCheckDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param jctbResultCheckDetail 实例对象
     * @return 实例对象
     */
    @Override
    public JctbResultCheckDetail insert(JctbResultCheckDetail jctbResultCheckDetail) {
        jctbResultCheckDetail.setId(idWorker.nextId());
        this.jctbResultCheckDetailDao.insert(jctbResultCheckDetail);
        return jctbResultCheckDetail;
    }

    /**
     * 修改数据
     *
     * @param jctbResultCheckDetail 实例对象
     * @return 实例对象
     */
    @Override
    public JctbResultCheckDetail update(JctbResultCheckDetail jctbResultCheckDetail) {
        this.jctbResultCheckDetailDao.update(jctbResultCheckDetail);
        return this.queryById(jctbResultCheckDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.jctbResultCheckDetailDao.deleteById(id) > 0;
    }

    @Override
    public int batchInsert(List<JctbResultCheckDetail> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbResultCheckDetailDao.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbResultCheckDetailDao.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbResultCheckDetail> listByTaskName(String taskName) {
        return jctbResultCheckDetailDao.listByTaskName(taskName);
    }

    @Override
    public List<JctbResultCheckDetailDto> listByTaskName2(String taskName) {
        List<JctbResultCheckDetail> details = jctbResultCheckDetailDao.listByTaskName(taskName);
        List<JctbResultCheckDetailDto> dtoList = JctbResultCheckDetailConverter.Instance.domain2dto(details);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }
}