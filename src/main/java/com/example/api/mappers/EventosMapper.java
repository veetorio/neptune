package com.example.api.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.model.Evento;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface EventosMapper extends MapperCaseOut<Evento,EventoDtoOut>  ,MapperCaseIn<EventoDtoIn,Evento> {
}
