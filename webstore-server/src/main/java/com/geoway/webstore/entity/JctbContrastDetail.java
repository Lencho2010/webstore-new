package com.geoway.webstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (JctbContrastDetail)实体类
 *
 * @author makejava
 * @since 2021-09-16 14:20:54
 */
@Data
@NoArgsConstructor
public class JctbContrastDetail implements Serializable {
    private static final long serialVersionUID = -86026210980840957L;

    private Long id;

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