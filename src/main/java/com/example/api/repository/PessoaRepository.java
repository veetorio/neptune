package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
    
}
