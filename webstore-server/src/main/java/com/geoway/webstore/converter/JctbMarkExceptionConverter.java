package com.geoway.webstore.converter;

import com.geoway.webstore.dto.JctbMarkExceptionDTO;
import com.geoway.webstore.entity.JctbMarkException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/16 18:22
 * @Description:
 */
@Mapper
public interface JctbMarkExceptionConverter {

    JctbMarkExceptionConverter Instance = Mappers.getMapper(JctbMarkExceptionConverter.class);

    @Mappings({
            @Mapping(target = "index", ignore = true),
    })
    JctbMarkExceptionDTO domain2dto(JctbMarkException domain);

    List<JctbMarkExceptionDTO> domain2dto(List<JctbMarkException> domain);
}
