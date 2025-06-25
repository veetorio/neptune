package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.model.Projeto;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface ProjetosMapper {
    Projeto mapToOrigin(ProjetoDtoIn dtoin);



    ProjetoDtoOut mapToOut(Projeto origin);

    
}
