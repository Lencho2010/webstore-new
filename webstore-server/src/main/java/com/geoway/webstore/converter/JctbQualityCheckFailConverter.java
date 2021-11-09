package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbQualityCheckFailDto;
import com.geoway.webstore.entity.JctbQualityCheckFail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 11:24
 * @Description:
 */
@Mapper
public interface JctbQualityCheckFailConverter {

    JctbQualityCheckFailConverter Instance = Mappers.getMapper(JctbQualityCheckFailConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbQualityCheckFailDto domain2dto(JctbQualityCheckFail domain);

    List<JctbQualityCheckFailDto> domain2dto(List<JctbQualityCheckFail> domain);
}
