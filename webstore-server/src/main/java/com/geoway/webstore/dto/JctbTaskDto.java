package com.geoway.webstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geoway.webstore.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 16:27
 * @Description:
 */
@Data
@NoArgsConstructor
public class JctbTaskDto {
    private Integer index;
    private String taskName;
    private String creator = "admin";

    @JsonFormat(pattern = Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date startTime;

    @JsonFormat(pattern = Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date endTime;

    //检测图斑数量
    private Integer tbCount;
    private Integer progress;
    private Integer status;

    private String consumeTime;
}
