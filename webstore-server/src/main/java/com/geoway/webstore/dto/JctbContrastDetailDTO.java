package com.geoway.webstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 14:48
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbContrastDetailDTO {

    private Long id;

    private Integer index;

    private String taskName;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private Integer originCount;

    private Integer resultCount;

    private Integer status;

    private String fail;

    private String info;
}
