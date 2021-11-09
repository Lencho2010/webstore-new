package com.geoway.webstore.dao;

import com.geoway.webstore.entity.ReportTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ReportTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
@Mapper
public interface ReportTemplateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportTemplate queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ReportTemplate> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<ReportTemplate> listByType(@Param("statisticType") String statisticType);

    List<ReportTemplate> listByCodes(@Param("codes") List<String> codes);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param reportTemplate 实例对象
     * @return 对象列表
     */
    List<ReportTemplate> queryAll(ReportTemplate reportTemplate);

    /**
     * 新增数据
     *
     * @param reportTemplate 实例对象
     * @return 影响行数
     */
    int insert(ReportTemplate reportTemplate);

    /**
     * 修改数据
     *
     * @param reportTemplate 实例对象
     * @return 影响行数
     */
    int update(ReportTemplate reportTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}