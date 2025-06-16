package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperCaseIn<TO, FROM> {
    FROM mapperDTOoriginIn(TO dtoin);

    TO mapperDTOIn(FROM dto);
}
