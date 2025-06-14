package com.example.api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.controller.dtos.EventoDtoUpdateOut;
import com.example.api.model.Evento;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface EventosMapper {
    Evento mapToOrigin(EventoDtoIn evento); 

    EventoDtoUpdateOut mapToUpdateOut(Evento evento);
    
    EventoDtoOut mapToDtoOut(Evento evento);
}
