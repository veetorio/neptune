package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.mappers.ProjetosMapper;
import com.example.api.model.Projetos;
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
            Projetos p = mapper
                    .mapperDTOoriginIn(event);
            repository.save(p);
            return mapper.mapToDtoOut(p);
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
            .map(e -> mapper.mapToDtoOut(e))
            .toList();
    }

    @Override
    public ProjetoDtoOut findById(Long id) {
        return mapper
            .mapToDtoOut(
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
        Projetos projetos = repository.findById(id).orElseThrow();
        projetos.setNome(entity.getNome());
        projetos.setTematica(entity.getTematica());

        return mapper.mapToDtoOut(projetos);
    }

}
