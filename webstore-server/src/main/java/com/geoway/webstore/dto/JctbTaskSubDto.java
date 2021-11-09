package com.geoway.webstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geoway.webstore.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 20:37
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbTaskSubDto {

    private Long id;

    private String taskName;

    private Short status;

    private Short progress;

    @JsonFormat(pattern= Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date startTime;

    @JsonFormat(pattern= Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date endTime;

    private Integer stepCode;

    private String stepName;

    private String consumeTime;

    private List<JctbTaskDetailDto> children;
}
