package com.geoway.webstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ReportTemplate)实体类
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportTemplate implements Serializable {
    private static final long serialVersionUID = -21321451997160761L;
    
    private Long id;
    /**
    * 模板名称
    */
    private String name;
    /**
    * 统计类型，关联report_type表中的type字段
    */
    private String statisticType;
    /**
    * 模板编号
    */
    private String code;
    /**
    * 模板展示排列顺序
    */
    private Integer sort;

    /**
     * 模板对应的路径
     */
    private String url;

    /**
     * 模板类型（word,excel）
     */
    private String docType;

    private String group;

}