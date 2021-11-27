package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbQualityCheckDetailDTO;
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
    JctbQualityCheckDetailDTO domain2dto(JctbQualityCheckDetail domain);

    List<JctbQualityCheckDetailDTO> domain2dto(List<JctbQualityCheckDetail> domain);
}
