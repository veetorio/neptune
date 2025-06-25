package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.mappers.ProjetosMapper;
import com.example.api.model.Projeto;
import com.example.api.repository.ProjetosRepository;
import com.example.api.service.interfaces.ServiceInterface;

@Service
public class ProjetoService implements ServiceInterface<ProjetoDtoOut, ProjetoDtoIn> {

    @Autowired
    private ProjetosRepository repository;

    @Autowired
    private ProjetosMapper mapper;

    @Override
    public ProjetoDtoOut create(ProjetoDtoIn event) {
        try {
            Projeto p = mapper
                    .mapToOrigin(event);
            repository.save(p);
            return mapper.mapToOut(p);
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ProjetoDtoOut> findAll() {
        return repository
            .findAll()
            .stream()
            .map(e -> mapper.mapToOut(e))
            .toList();
    }

    @Override
    public ProjetoDtoOut findById(Long id) {
        return mapper
            .mapToOut(
                repository
                    .findById(id)
                    .orElseThrow()
            );
    }

    @Override
    public String delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow());
        return "Deleção feita com sucesso";
    }

    @Override
    public ProjetoDtoOut update(Long id, ProjetoDtoIn entity) {
        Projeto projeto = repository.findById(id).orElseThrow();
        projeto.setNome(entity.getNome());
        projeto.setTematica(entity.getTematica());

        return mapper.mapToOut(projeto);
    }

}
