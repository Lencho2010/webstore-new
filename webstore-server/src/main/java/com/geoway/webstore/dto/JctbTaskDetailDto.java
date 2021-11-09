package com.geoway.webstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geoway.webstore.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 21:29
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbTaskDetailDto {
    private Long id;

    private Long parentId;

    private String taskName;

    private Short status;

    private String log;

    @JsonFormat(pattern = Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date startTime;

    @JsonFormat(pattern = Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date endTime;

    private Integer stepCode;

    private String stepInfo;

    private String consumeTime;
}
