package com.geoway.webstore.service.impl;

import com.geoway.webstore.dao.TbsysParaDao;
import com.geoway.webstore.entity.TbsysPara;
import com.geoway.webstore.service.TbsysParaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lencho
 * @create 2021-09-09 9:19
 * @desc
 */
@Service
public class TbsysParaServiceImpl implements TbsysParaService {

    @Resource
    TbsysParaDao tbsysParaDao;

    @Override
    public TbsysPara findOne(String key) {
        return tbsysParaDao.findOne(key);
    }

    @Override
    public boolean update(String key, String value) {
        return tbsysParaDao.update(key, value);
    }
}
