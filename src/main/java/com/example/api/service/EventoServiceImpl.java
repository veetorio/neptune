package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.controller.dtos.EventoDtoUpdateOut;
import com.example.api.mappers.EventosMapper; // ERRADO!
import com.example.api.model.Evento;
import com.example.api.repository.EventoRepository;


@Service
public class EventoServiceImpl {
    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventosMapper mapper;

    public EventoDtoOut create(EventoDtoIn event) {
        try {
            Evento entity = mapper.mapToOrigin(event);
            entity.setInvestido(entity.getInvestido() * 100);
            entity = repository.save(entity);

            return mapper.mapToDtoOut(entity);
            // return null;
        } catch (Exception e) {
            System.out.println("Error em criar evento");
            return null;
        }
    }

    public List<EventoDtoOut> findAll() {
        try {

            return repository
                    .findAll()
                    .stream()
                    .map(e -> mapper.mapToDtoOut(e))
                    .toList();
        } catch (Exception e) {
            System.out.println("Error em pegar evento" + e.getLocalizedMessage());
            return null;
        }
    }

    public EventoDtoUpdateOut findById(Long id) {
        try {
            Evento entity = repository
                        .findById(id).orElseThrow();
            entity.setArrecadacao(entity.getArrecadacao()/100);
            entity.setInvestido(entity.getInvestido()/100);
            return mapper
                .mapToUpdateOut( 
                    repository
                        .findById(id).orElseThrow());
            } catch (Exception e) {
            System.out.println("Error em pegar evento" + e.getLocalizedMessage());
            return null;
        }
    }

    public String delete(Long id) {
        try {
            Evento ev = repository.findById(id).orElseThrow();
            repository.delete(ev);
            return "OK";
        } catch (RuntimeException e) {
            return "Erro";
        }
    }

    public EventoDtoUpdateOut update(EventoDtoUpdateOut ev,Long id) {
        try {
            Evento evento = repository.findById(id).orElseThrow();
            


            return mapper.mapToUpdateOut(evento);

        } catch (RuntimeException a) {
            return null;
        }
    }
}
