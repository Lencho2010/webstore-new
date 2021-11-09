package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbTaskDetailDto;
import com.geoway.webstore.entity.JctbTaskDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 21:31
 * @Description:
 */
@Mapper
public interface JctbTaskDetailConverter {

    JctbTaskDetailConverter Instance = Mappers.getMapper(JctbTaskDetailConverter.class);

    @Mappings({
            @Mapping(target = "consumeTime", expression = "java(com.geoway.webstore.util.ConsumeTimeUtil.calculateTimeDifference(domain.getStartTime(),domain.getEndTime()))")
    })
    JctbTaskDetailDto domain2dto(JctbTaskDetail domain);

    List<JctbTaskDetailDto> domain2dto(List<JctbTaskDetail> domain);
}
