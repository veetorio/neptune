package com.example.api.controller.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ProjetoDtoOut {
    private Long id;
    private String nome;
    private String tematica;
    private List<PessoaSimples> inscritos;
    
}
