package com.geoway.webstore.dao;

import com.geoway.webstore.entity.TbsysPara;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lencho
 * @create 2021-09-09 9:06
 * @desc
 */
@Mapper
public interface TbsysParaDao {

    TbsysPara findOne(@Param("key") String key);

    boolean update(@Param("key") String key, @Param("value") String value);
}
