package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbResultCheckDetailDTO;
import com.geoway.webstore.entity.JctbResultCheckDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 17:32
 * @Description:
 */
@Mapper
public interface JctbResultCheckDetailConverter {

    JctbResultCheckDetailConverter Instance = Mappers.getMapper(JctbResultCheckDetailConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbResultCheckDetailDTO domain2dto(JctbResultCheckDetail domain);

    List<JctbResultCheckDetailDTO> domain2dto(List<JctbResultCheckDetail> domain);
}
