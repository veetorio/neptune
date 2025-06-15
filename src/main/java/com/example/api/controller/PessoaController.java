package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.controller.controllerModel.RestControllerNeptune;
import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.service.PessoaServiceImpl;
import com.example.api.utils.LoggerWatcher;

import jakarta.transaction.Transactional;


@LoggerWatcher
@RestController
@RequestMapping("/pessoa")
@Transactional
@CrossOrigin("*")
public class PessoaController implements RestControllerNeptune<PessoaDtoIn,PessoaDtoOut> {

    @Autowired
    private PessoaServiceImpl service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDtoOut> getEntity(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    
    @Override
    @PostMapping
    public ResponseEntity<PessoaDtoOut> createEntity(@RequestBody PessoaDtoIn entity) {
        return ResponseEntity.ok().body(service.create(entity));
    }
    
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
    
    @Override
    @GetMapping
    public ResponseEntity<List<PessoaDtoOut>> getAllEntitys() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDtoOut> updateEntity(@PathVariable Long id,@RequestBody PessoaDtoIn entity) {
        return ResponseEntity.ok().body(service.update(id,entity));
    }


    
}
