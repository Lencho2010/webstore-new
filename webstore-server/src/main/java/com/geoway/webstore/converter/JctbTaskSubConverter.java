package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbTaskSubDto;
import com.geoway.webstore.entity.JctbTaskSub;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 20:38
 * @Description:
 */
@Mapper
public interface JctbTaskSubConverter {
    JctbTaskSubConverter Instance = Mappers.getMapper(JctbTaskSubConverter.class);

    @Mappings({
            @Mapping(target = "children", ignore = true),
            @Mapping(target = "consumeTime", expression = "java(com.geoway.webstore.util.ConsumeTimeUtil.calculateTimeDifference(domain.getStartTime(),domain.getEndTime()))")
    })
    JctbTaskSubDto domain2dto(JctbTaskSub domain);

    List<JctbTaskSubDto> domain2dto(List<JctbTaskSub> domain);
}
