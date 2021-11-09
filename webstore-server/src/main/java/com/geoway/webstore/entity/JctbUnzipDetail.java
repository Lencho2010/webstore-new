package com.geoway.webstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JctbUnzipDetail {
    private Long id;

    private String taskName;

    private String dataName;

    private String dataPath;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

}