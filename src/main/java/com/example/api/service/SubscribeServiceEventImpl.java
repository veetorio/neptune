package com.example.api.service;

import java.util.NoSuchElementException;

import com.example.api.service.interfaces.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Evento;
import com.example.api.model.Pessoa;
import com.example.api.repository.EventoRepository;
import com.example.api.repository.PessoaRepository;

@Service
public class SubscribeServiceEventImpl implements SubscribeService {
    @Autowired
    private PessoaRepository repository;
    @Autowired
    private EventoRepository EventoRepository;

    @Override
    public void subscribe(Long eventId, Long usuarioId) {
        try {
            Pessoa p = repository.findById(usuarioId).orElseThrow();
            Evento e = EventoRepository.findById(eventId).orElseThrow();
            p.getEventos().add(e);
            e.getEscricoes().add(p);
            e.setEscricoes(e.getEscricoes());
            p.setEventos(p.getEventos());

            repository.save(p);
        } catch (NoSuchElementException e) {
            System.out.println("Elemento não foi encontrado");
        }
    }
}
