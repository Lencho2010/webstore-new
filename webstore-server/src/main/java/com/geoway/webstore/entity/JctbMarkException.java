package com.geoway.webstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (JctbMarkException)实体类
 *
 * @author makejava
 * @since 2021-09-16 18:14:28
 */
@Data
@NoArgsConstructor
public class JctbMarkException implements Serializable {
    private static final long serialVersionUID = -55192571208571552L;
    
    private Long id;
    
    private String taskName;
    
    private String provinceCode;
    
    private String provinceName;
    
    private String cityCode;
    
    private String cityName;
    
    private String countyCode;
    
    private String countyName;
    
    private String jcbh;
    
    private String errorType;
    
    private String errorDesc;
    
    private Integer isMark;
    
    private String markReason;
    /**
    * 1002-质量检查；1003-套合比对；1004-成果检查
    */
    private Integer stepCode;

}