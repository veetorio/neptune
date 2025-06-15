package com.example.api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.mappers.EventosMapper; // ERRADO!
import com.example.api.model.Evento;
import com.example.api.repository.EventoRepository;
import com.example.api.service.interfaces.ServiceInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventoServiceImpl implements ServiceInterface<EventoDtoOut, EventoDtoIn> {
    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventosMapper mapper;

    @Override
    public EventoDtoOut create(EventoDtoIn event) {
        try {
            Evento entity = mapper.mapperDTOoriginIn(event);
            entity.setInvestido(event.getInvestido().multiply(BigDecimal.TEN));
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

    @Override
    public EventoDtoOut update(Long id, EventoDtoIn ev) {
        BigDecimal baseTen = BigDecimal.TEN;
        try {
            Evento evento = repository.findById(id).orElseThrow();
            evento.setArrecadacao(ev.getArrecadacao().multiply(baseTen));
            evento.setAtividade(ev.isAtividade());
            evento.setInvestido(ev.getInvestido().multiply(baseTen));
            evento.setDateGo(ev.getDateGo());
            evento.setDateEnd(ev.getDateEnd());
            evento.setTimeGo(ev.getTimeGo());
            evento.setTimeEnd(ev.getTimeEnd());
            return mapper.mapToDtoOut(evento);

        } catch (RuntimeException a) {
            return null;
        }
    }

    @Override
    public EventoDtoOut findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
