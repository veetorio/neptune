package com.example.api.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.mappers.PessoaMapper;
import com.example.api.model.Evento;
import com.example.api.model.Pessoa;
import com.example.api.repository.EventoRepository;
import com.example.api.repository.PessoaRepository;
import com.example.api.service.interfaces.ServiceInterface;

@Service
public class PessoaServiceImpl implements ServiceInterface<PessoaDtoOut,PessoaDtoIn> {
    @Autowired
    private PessoaRepository repository;
    @Autowired
    private EventoRepository EventoRepository;
    @Autowired 
    private PessoaMapper mapper;

    @Override
    public PessoaDtoOut create(PessoaDtoIn entity) {
        try {
            Pessoa pessoa = mapper.mapperToOriginPessoa(entity);
        
            int idade = Period.between(pessoa.getNascimento(),LocalDate.now()).getYears();
            pessoa.setIdade(idade);
            repository.save(pessoa);
            return mapper.mapperToDtoOut(pessoa);
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public List<PessoaDtoOut> findAll() {

        return repository
        .findAll()
        .stream()
        .map(e -> mapper.mapperToDtoOut(e))
        .toList();

    }
    @Override
    public PessoaDtoOut findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        return mapper.mapperToDtoOut(pessoa);
    }
    @Override
    public String delete(Long id) {
        try {
            Pessoa p = repository.findById(id).orElseThrow();
            repository.delete(p);
            return "Errado";
        } catch(RuntimeException e) {
            return "ERRO";
        }
    }
    
    public PessoaDtoOut update(PessoaDtoIn ev, Long id) {
        Pessoa p = repository.findById(id).orElseThrow();
        p.setAtividade(ev.isAtividade());
        p.setNome(ev.getNome());
        p.setNascimento(ev.getNascimento());
        p.setLocal(ev.getLocal());

        repository.save(p);

        return mapper.mapperToDtoOut(p);
    }

    public void subscribe(Long eventId,Long usuarioId) {
        try {
            Pessoa p = repository.findById(usuarioId).orElseThrow();
            Evento e = EventoRepository.findById(eventId).orElseThrow();
            p.getEventos().add(e);
            e.getEscricoes().add(p);
            e.setEscricoes(e.getEscricoes());
            p.setEventos(p.getEventos());

            repository.save(p);
        } catch(NoSuchElementException e) {
            System.out.println("Elemento não foi encontrado");
        }
    }
    

    
    
}
