package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Projetos;

public interface ProjetosRepository extends JpaRepository<Projetos,Long> {
    
}
