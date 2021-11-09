package com.geoway.webstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (JctbResultCheckDetail)实体类
 *
 * @author makejava
 * @since 2021-09-16 17:22:53
 */
@Data
@NoArgsConstructor
public class JctbResultCheckDetail implements Serializable {
    private static final long serialVersionUID = -66540942976041565L;
    
    private Long id;
    
    private String taskName;
    
    private String provinceCode;
    
    private String provinceName;
    
    private String cityCode;
    
    private String cityName;
    
    private String countyCode;
    
    private String countyName;
    
    private Integer status;
    
    private String info;

    private String ruleCode;

    private String ruleName;

}