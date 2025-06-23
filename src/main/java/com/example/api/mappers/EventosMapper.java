package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;

import com.example.api.model.Evento;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventosMapper {
    @Mapping(target = "escricoes",ignore = true)
    @Mapping(target = "idEvento",ignore = true)
    Evento mapToOrigin(EventoDtoIn dtoin);

    @Mapping(target = "dateGo",ignore = true)
    EventoDtoOut mapToOut(Evento entity);
}
