package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.utils.LoggerWatcher;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.api.controller.controllerModel.RestControllerNeptune;
import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.service.EventoServiceImpl;

import jakarta.transaction.Transactional;


@LoggerWatcher
@RestController
@RequestMapping("/eventos")
@Transactional
@CrossOrigin("*")
public class EventosController implements RestControllerNeptune<EventoDtoIn, EventoDtoOut> {
    @Autowired
    private EventoServiceImpl service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EventoDtoOut> getEntity(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EventoDtoOut> updateEntity(@PathVariable Long id,
            @RequestBody EventoDtoIn entity) {
        return ResponseEntity.ok().body(service.update(id,entity));
    }

    @PostMapping
    @Override
    public ResponseEntity<EventoDtoOut> createEntity(@RequestBody EventoDtoIn entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }



    @GetMapping
    @Override
    public ResponseEntity<List<EventoDtoOut>> getAllEntitys() {
        return ResponseEntity.ok().body(service.findAll());
    }



}
