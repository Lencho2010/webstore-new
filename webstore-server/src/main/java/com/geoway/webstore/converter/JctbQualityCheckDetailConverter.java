package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbQualityCheckDetailDto;
import com.geoway.webstore.entity.JctbQualityCheckDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:25
 * @Description:
 */
@Mapper
public interface JctbQualityCheckDetailConverter {
    JctbQualityCheckDetailConverter Instance = Mappers.getMapper(JctbQualityCheckDetailConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbQualityCheckDetailDto domain2dto(JctbQualityCheckDetail domain);

    List<JctbQualityCheckDetailDto> domain2dto(List<JctbQualityCheckDetail> domain);
}
