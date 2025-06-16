package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.model.Pessoa;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper extends MapperCaseOut<Pessoa,PessoaDtoOut> , MapperCaseIn<PessoaDtoIn,Pessoa> {
    
}
