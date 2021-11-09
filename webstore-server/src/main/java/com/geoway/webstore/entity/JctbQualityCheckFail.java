package com.geoway.webstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JctbQualityCheckFail {
    private Long id;

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