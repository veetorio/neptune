package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Evento;


public interface EventoRepository extends JpaRepository<Evento,Long> {
    
}
