package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.model.Pessoa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {
    @Mapping(source = "nascimento", target = "nascimento")
    @Mapping(source = "atividade", target = "atividade")
    @Mapping(source = "local", target = "local")
    @Mapping(source = "senha", target = "senha")
    @Mapping(target = "eventos", ignore = true)
    @Mapping(target = "projetos", ignore = true)
    Pessoa mapToOrigin(PessoaDtoIn dtoin);

    PessoaDtoOut mapToOut(Pessoa entity);

}
