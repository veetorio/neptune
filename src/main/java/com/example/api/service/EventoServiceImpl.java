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
import com.example.api.service.interfaces.ServiceEventos;


@Service
public class EventoServiceImpl implements ServiceEventos<EventoDtoOut,EventoDtoIn,EventoDtoUpdateOut> {
    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventosMapper mapper;

    @Override
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
    
    @Override
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

    public EventoDtoUpdateOut findUpdateById(Long id) {
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
        
        @Override
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
            evento.setArrecadacao(ev.getArrecadacao() * 100);
            evento.setAtividade(ev.isAtividade());
            evento.setInvestido(ev.getInvestido() * 100);
            evento.setDateGo(ev.getDateGo());
            evento.setDateEnd(ev.getDateEnd());
            evento.setTimeGo(ev.getTimeGo());
            evento.setTimeEnd(ev.getTimeEnd());
        
            return mapper.mapToUpdateOut(evento);

        } catch (RuntimeException a) {
            return null;
        }
    }
}
