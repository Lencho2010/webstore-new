package com.geoway.webstore.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 18:21
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbMarkExceptionDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Integer index;

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
