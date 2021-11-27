package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbContrastDetailConverter;
import com.geoway.webstore.dto.JctbContrastDetailDTO;
import com.geoway.webstore.entity.JctbContrastDetail;
import com.geoway.webstore.dao.JctbContrastDetailDao;
import com.geoway.webstore.service.JctbContrastDetailService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (JctbContrastDetail)表服务实现类
 *
 * @author makejava
 * @since 2021-09-16 14:24:41
 */
@Service("jctbContrastDetailService")
public class JctbContrastDetailServiceImpl implements JctbContrastDetailService {

    @Resource
    private IDWorker idWorker;

    @Resource
    private JctbContrastDetailDao jctbContrastDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JctbContrastDetail queryById(Long id) {
        return this.jctbContrastDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<JctbContrastDetail> queryAllByLimit(int offset, int limit) {
        return this.jctbContrastDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 实例对象
     */
    @Override
    public JctbContrastDetail insert(JctbContrastDetail jctbContrastDetail) {
        jctbContrastDetail.setId(idWorker.nextId());
        this.jctbContrastDetailDao.insert(jctbContrastDetail);
        return jctbContrastDetail;
    }

    /**
     * 修改数据
     *
     * @param jctbContrastDetail 实例对象
     * @return 实例对象
     */
    @Override
    public JctbContrastDetail update(JctbContrastDetail jctbContrastDetail) {
        this.jctbContrastDetailDao.update(jctbContrastDetail);
        return this.queryById(jctbContrastDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.jctbContrastDetailDao.deleteById(id) > 0;
    }

    @Override
    public int batchInsert(List<JctbContrastDetail> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbContrastDetailDao.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbContrastDetailDao.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbContrastDetail> listByTaskName(String taskName) {
        return jctbContrastDetailDao.listByTaskName(taskName);
    }

    @Override
    public List<JctbContrastDetailDTO> listByTaskName2(String taskName) {
        List<JctbContrastDetail> details = jctbContrastDetailDao.listByTaskName(taskName);
        List<JctbContrastDetailDTO> dtoList = JctbContrastDetailConverter.Instance.domain2dto(details);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }
}