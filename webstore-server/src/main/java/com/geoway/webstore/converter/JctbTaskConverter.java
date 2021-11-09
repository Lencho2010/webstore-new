package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbTaskDto;
import com.geoway.webstore.entity.JctbTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 16:28
 * @Description:
 */
@Mapper
public interface JctbTaskConverter {

    JctbTaskConverter Instance = Mappers.getMapper(JctbTaskConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
            @Mapping(target = "consumeTime", expression = "java(com.geoway.webstore.util.ConsumeTimeUtil.calculateTimeDifference(domain.getStartTime(),domain.getEndTime()))")
    })
    JctbTaskDto domain2dto(JctbTask domain);

    List<JctbTaskDto> domain2dto(List<JctbTask> domain);
}
