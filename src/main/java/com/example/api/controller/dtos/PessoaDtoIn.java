package com.example.api.controller.dtos;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class PessoaDtoIn {

    private String nome;
    
    private LocalDate nascimento;
    
    private boolean atividade;

    private String local;

    private String senha;
}
