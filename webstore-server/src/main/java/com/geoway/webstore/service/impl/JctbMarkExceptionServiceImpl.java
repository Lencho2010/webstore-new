package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbMarkExceptionConverter;
import com.geoway.webstore.dto.JctbMarkExceptionDto;
import com.geoway.webstore.entity.JctbMarkException;
import com.geoway.webstore.dao.JctbMarkExceptionDao;
import com.geoway.webstore.service.JctbMarkExceptionService;
import com.geoway.webstore.util.IDWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (JctbMarkException)表服务实现类
 *
 * @author makejava
 * @since 2021-09-16 18:14:28
 */
@Service("jctbMarkExceptionService")
public class JctbMarkExceptionServiceImpl implements JctbMarkExceptionService {
    @Resource
    private JctbMarkExceptionDao jctbMarkExceptionDao;

    @Resource
    private IDWorker idWorker;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JctbMarkException queryById(Long id) {
        return this.jctbMarkExceptionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<JctbMarkException> queryAllByLimit(int offset, int limit) {
        return this.jctbMarkExceptionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param jctbMarkException 实例对象
     * @return 实例对象
     */
    @Override
    public JctbMarkException insert(JctbMarkException jctbMarkException) {
        jctbMarkException.setId(idWorker.nextId());
        this.jctbMarkExceptionDao.insert(jctbMarkException);
        return jctbMarkException;
    }

    /**
     * 修改数据
     *
     * @param jctbMarkException 实例对象
     * @return 实例对象
     */
    @Override
    public JctbMarkException update(JctbMarkException jctbMarkException) {
        this.jctbMarkExceptionDao.update(jctbMarkException);
        return this.queryById(jctbMarkException.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.jctbMarkExceptionDao.deleteById(id) > 0;
    }

    @Override
    public int batchUpdate(List<JctbMarkException> records) {
        return records.stream().mapToInt(r -> this.jctbMarkExceptionDao.update(r)).sum();
    }

    @Override
    public int batchInsert(List<JctbMarkException> records) {
        records.forEach(r -> r.setId(idWorker.nextId()));
        return jctbMarkExceptionDao.batchInsert(records);
    }

    @Override
    public int deleteByTaskName(String taskName) {
        return jctbMarkExceptionDao.deleteByTaskName(taskName);
    }

    @Override
    public List<JctbMarkException> listByTaskName(String taskName) {
        return jctbMarkExceptionDao.listByTaskName(taskName);
    }

    @Override
    public List<JctbMarkExceptionDto> listByTaskName2(String taskName) {
        List<JctbMarkException> details = jctbMarkExceptionDao.listByTaskName(taskName);
        List<JctbMarkExceptionDto> dtoList = JctbMarkExceptionConverter.Instance.domain2dto(details);
        IntStream.range(0, dtoList.size()).forEach(i -> dtoList.get(i).setIndex(i + 1));
        return dtoList;
    }
}