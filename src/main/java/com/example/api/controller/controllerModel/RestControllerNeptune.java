package com.example.api.controller.controllerModel;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;


public interface RestControllerNeptune <DTOIN,DTOOUT> {
    ResponseEntity<DTOOUT> getEntity(Long id);
    ResponseEntity<List<DTOOUT>> getAllEntitys();
    public ResponseEntity<DTOOUT> createEntity(DTOIN entity);
    public ResponseEntity<String> deleteEntity(Long id);
}
