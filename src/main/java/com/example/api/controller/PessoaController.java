package com.example.api.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.controller.controllerModel.RestControllerNeptune;
import com.example.api.controller.dtos.PessoaDtoIn;
import com.example.api.controller.dtos.PessoaDtoOut;
import com.example.api.service.PessoaServiceImpl;
import com.example.api.utils.LoggerWatcher;

@LoggerWatcher
@RestController
@RequestMapping("/pessoa")
@CrossOrigin("*")
public class PessoaController implements RestControllerNeptune<PessoaDtoIn,PessoaDtoOut> {

    @Autowired
    private PessoaServiceImpl service;

    @Override
    @GetMapping
    public ResponseEntity<PessoaDtoOut> getEntity(Long id) {
        // TODO Auto-generated method stub
        return ResponseEntity.ok().body(service.findById(id));
    }

    public ResponseEntity<PessoaDtoOut> updateEntity(Long id, PessoaDtoIn entity) {
        return ResponseEntity.ok().body(service.create(entity));
    }

    @Override
    @PostMapping
    public ResponseEntity<PessoaDtoOut> createEntity(@RequestBody PessoaDtoIn entity) {
        // TODO Auto-generated method stub
       return ResponseEntity.ok().body(service.create(entity));
    }

    @Override
    public ResponseEntity<String> deleteEntity(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEntity'");
    }

    @Override
    public ResponseEntity<List<PessoaDtoOut>> getAllEntitys() {
        // TODO Auto-generated method stub
        return ResponseEntity.ok().body(service.findAll());
    }

 
    
}
