package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.model.Pessoa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {
    Pessoa mapToOrigin(PessoaDtoIn dtoin);

    @Mapping(target = "idade",ignore = true)
    PessoaDtoOut mapToOut(Pessoa entity);

}
