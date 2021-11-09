package com.geoway.webstore.dao;

import com.geoway.webstore.entity.ReportType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ReportType)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-02 14:39:15
 */
@Mapper
public interface ReportTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportType queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReportType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reportType 实例对象
     * @return 对象列表
     */
    List<ReportType> queryAll(ReportType reportType);

    /**
     * 新增数据
     *
     * @param reportType 实例对象
     * @return 影响行数
     */
    int insert(ReportType reportType);

    /**
     * 修改数据
     *
     * @param reportType 实例对象
     * @return 影响行数
     */
    int update(ReportType reportType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}