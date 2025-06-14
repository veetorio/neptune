package com.example.api.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.mappers.PessoaMapper;
import com.example.api.model.Evento;
import com.example.api.model.Pessoa;
import com.example.api.repository.EventoRepository;
import com.example.api.repository.PessoaRepository;
import com.example.api.service.interfaces.ServiceInterface;

@Service
@Transactional
public class PessoaServiceImpl implements ServiceInterface<PessoaDtoOut, PessoaDtoIn> {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaMapper mapper;

    @Override
    public PessoaDtoOut create(PessoaDtoIn entity) {
        try {
            Pessoa pessoa = mapper.mapperDTOoriginIn(entity);
            
            repository.save(pessoa);
            int idade = Period.between(pessoa.getNascimento(), LocalDate.now()).getYears();
            PessoaDtoOut pessoaOut = mapper.mapToDtoOut(pessoa);
            
            pessoaOut.setIdade(idade);
            return pessoaOut;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public List<PessoaDtoOut> findAll() {

        return repository
                .findAll()
                .stream()
                .map(e -> {
                    PessoaDtoOut p = mapper.mapToDtoOut(e);
                    if (e.getNascimento() != null) {
                        int idade = Period.between(e.getNascimento(), LocalDate.now()).getYears();
                        p.setIdade(idade);
                    } else {
                        p.setIdade(0); // Ou zero, ou algum valor padrão
                    }
                    return p;
                })
                .toList();

    }

    @Override
    public PessoaDtoOut findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        return mapper.mapToDtoOut(pessoa);
    }

    @Override
    public String delete(Long id) {
        try {
            Pessoa p = repository.findById(id).orElseThrow();
            repository.delete(p);
            return "Deletado com sucesso";
        } catch (RuntimeException e) {
            return "informamos que houver erro na deleção";
        }
    }

    @Override
    public PessoaDtoOut update(Long id, PessoaDtoIn ev) {
        Pessoa p = repository.findById(id).orElseThrow();
        p.setAtividade(ev.isAtividade());
        p.setNome(ev.getNome());
        p.setNascimento(ev.getNascimento());

        p.setLocal(ev.getLocal());

        repository.save(p);

        return mapper.mapToDtoOut(p);
    }

}
