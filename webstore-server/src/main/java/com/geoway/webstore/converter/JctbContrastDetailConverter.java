package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbContrastDetailDTO;
import com.geoway.webstore.entity.JctbContrastDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 14:49
 * @Description:
 */
@Mapper
public interface JctbContrastDetailConverter {
    JctbContrastDetailConverter Instance = Mappers.getMapper(JctbContrastDetailConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbContrastDetailDTO domain2dto(JctbContrastDetail domain);

    List<JctbContrastDetailDTO> domain2dto(List<JctbContrastDetail> domain);
}
