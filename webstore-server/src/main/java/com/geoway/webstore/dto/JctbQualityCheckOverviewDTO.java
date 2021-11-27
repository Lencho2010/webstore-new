package com.geoway.webstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 10:28
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbQualityCheckOverviewDTO {

    private Long id;

    private Integer index;

    private String taskName;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private Short status;

    private String info;
}
