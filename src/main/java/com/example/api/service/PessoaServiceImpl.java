package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.EventoDtoUpdateOut;
import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.mappers.PessoaMapper;
import com.example.api.model.Pessoa;
import com.example.api.repository.PessoaRepository;
import com.example.api.service.interfaces.ServiceInterface;

@Service
public class PessoaServiceImpl implements ServiceInterface<PessoaDtoOut,PessoaDtoIn> {
    @Autowired
    private PessoaRepository repository;
    @Autowired 
    private PessoaMapper mapper;

    @Override
    public PessoaDtoOut create(PessoaDtoIn entity) {
        try {
            Pessoa pessoa = mapper.mapperToOriginPessoa(entity);
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
            repository.delete(repository.findById(id).orElseThrow());
            return "Errado";
        } catch(RuntimeException e) {
            return "ERRO";
        }
    }
    @Override
    public PessoaDtoOut update(EventoDtoUpdateOut ev, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    

    
    
}
