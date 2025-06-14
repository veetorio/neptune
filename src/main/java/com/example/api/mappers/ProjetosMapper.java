package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.model.Projetos;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface ProjetosMapper extends MapperCaseOut<Projetos,ProjetoDtoOut> ,MapperCaseIn<ProjetoDtoIn,Projetos>{
    
}
