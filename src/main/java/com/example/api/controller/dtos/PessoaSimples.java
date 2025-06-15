package com.example.api.controller.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class PessoaSimples {

    private Long id;

    private int idade;

    private String local;

    private String nome;

    private boolean atividade;
}
