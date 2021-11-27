package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbUnzipDetailDTO;
import com.geoway.webstore.entity.JctbUnzipDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 9:32
 * @Description:
 */
@Mapper
public interface JctbUnzipDetailConverter {
    JctbUnzipDetailConverter Instance = Mappers.getMapper(JctbUnzipDetailConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true)
    })
    JctbUnzipDetailDTO domain2dto(JctbUnzipDetail domain);

    List<JctbUnzipDetailDTO> domain2dto(List<JctbUnzipDetail> domain);
}
