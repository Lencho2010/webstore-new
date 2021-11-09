package com.geoway.webstore.service;

import com.geoway.webstore.entity.ReportTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ReportTemplate)表服务接口
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
public interface ReportTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportTemplate queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReportTemplate> queryAllByLimit(int offset, int limit);

    List<ReportTemplate> listByType(String statisticType);

    List<ReportTemplate> listByCodes(List<String> codes);

    /**
     * 新增数据
     *
     * @param reportTemplate 实例对象
     * @return 实例对象
     */
    ReportTemplate insert(ReportTemplate reportTemplate);

    /**
     * 修改数据
     *
     * @param reportTemplate 实例对象
     * @return 实例对象
     */
    ReportTemplate update(ReportTemplate reportTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}