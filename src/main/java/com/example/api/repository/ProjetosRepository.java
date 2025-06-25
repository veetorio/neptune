package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Projeto;

public interface ProjetosRepository extends JpaRepository<Projeto,Long> {
    
}
