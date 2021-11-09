package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbQualityCheckOverviewDto;
import com.geoway.webstore.entity.JctbQualityCheckOverview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 10:30
 * @Description:
 */
@Mapper
public interface JctbQualityCheckOverviewConverter {

    JctbQualityCheckOverviewConverter Instance = Mappers.getMapper(JctbQualityCheckOverviewConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbQualityCheckOverviewDto domain2dto(JctbQualityCheckOverview domain);

    List<JctbQualityCheckOverviewDto> domain2dto(List<JctbQualityCheckOverview> domain);
}
