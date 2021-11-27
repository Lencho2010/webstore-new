package com.geoway.webstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:23
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbQualityCheckFailDTO {

    private Long id;

    private Integer index;

    private String taskName;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private String ruleCode;

    private String ruleName;

    private String tbbh;

    private String finalResult;
}
