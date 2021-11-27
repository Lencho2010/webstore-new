package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbQualityCheckFailDTO;
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
    JctbQualityCheckFailDTO domain2dto(JctbQualityCheckFail domain);

    List<JctbQualityCheckFailDTO> domain2dto(List<JctbQualityCheckFail> domain);
}
