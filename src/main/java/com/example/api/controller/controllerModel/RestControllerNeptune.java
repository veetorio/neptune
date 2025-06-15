package com.example.api.controller.controllerModel;

import java.util.List;

import org.springframework.http.ResponseEntity;



public interface RestControllerNeptune <DTOIN,DTOOUT> {
    ResponseEntity<DTOOUT> getEntity(Long id);
    ResponseEntity<List<DTOOUT>> getAllEntitys();
    public ResponseEntity<DTOOUT> createEntity(DTOIN entity);
    public ResponseEntity<String> deleteEntity(Long id);
    public ResponseEntity<DTOOUT> updateEntity(Long id,DTOIN entity);
}
