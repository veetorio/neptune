package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PessoaDtoIn {

    private String nome;
    
    private LocalDate nascimento;
    
    private boolean atividade;

    private String local;

    private String senha;
}
