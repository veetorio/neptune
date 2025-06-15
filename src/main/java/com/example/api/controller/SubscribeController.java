package com.example.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.SubscribeService;
import com.example.api.utils.LoggerWatcher;

@LoggerWatcher
@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService service;
    
    private final int create = HttpStatus.CREATED.ordinal();
    private final Map<String,String> response = Map.of("response", "escrição realizada com sucesso, realize a proxima etapa.");
    @PostMapping("/events")
    public ResponseEntity<Map<String,String>> subscribe(@RequestParam Long eventId,
            @RequestParam Long userId) {
        service.subscribe(eventId, userId);
        return ResponseEntity.status(create).body(response);
    }

    @PostMapping("/projects")
    public ResponseEntity<Map<String,String>> getMethodName(@RequestParam Long projectId , 
        @RequestParam Long userId ) {
        return ResponseEntity.status(create).body(response);
    }

}
