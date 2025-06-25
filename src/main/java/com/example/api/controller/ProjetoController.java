package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.controller.controllerModel.RestControllerNeptune;
import com.example.api.controller.dtos.ProjetoDtoIn;
import com.example.api.controller.dtos.ProjetoDtoOut;
import com.example.api.service.ProjetoServiceImpl;
import com.example.api.utils.LoggerWatcher;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/projeto")
@LoggerWatcher
@Transactional
@CrossOrigin("*")
public class ProjetoController implements RestControllerNeptune<ProjetoDtoIn,ProjetoDtoOut> {
    @Autowired
    private ProjetoServiceImpl projetoServiceImpl;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDtoOut> getEntity(@PathVariable Long id) {
        return ResponseEntity.ok().body(projetoServiceImpl.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProjetoDtoOut>> getAllEntitys() {
        return ResponseEntity.ok().body(projetoServiceImpl.findAll());
    }

    @Override
    @PostMapping
    public ResponseEntity<ProjetoDtoOut> createEntity(@RequestBody ProjetoDtoIn entity) {
        return ResponseEntity.status(201).body(projetoServiceImpl.create(entity));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        return ResponseEntity.ok().body(projetoServiceImpl.delete(id));
    }

    @Override
    public ResponseEntity<ProjetoDtoOut> updateEntity(Long id, ProjetoDtoIn entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }


    
}
