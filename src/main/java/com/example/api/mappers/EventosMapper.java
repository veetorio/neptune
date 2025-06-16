package com.example.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.model.Evento;
import com.example.api.model.Projetos;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventosMapper {
    Evento mapToOrigin(EventoDtoIn dtoin);

    EventoDtoOut mapToOut(Evento entity);
}
