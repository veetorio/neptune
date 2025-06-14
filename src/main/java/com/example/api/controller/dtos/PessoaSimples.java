package com.example.api.controller.dtos;

import lombok.Data;

@Data
public class PessoaSimples {

    private Long id;

    private int idade;

    private String local;

    private String nome;

    private boolean atividade;
}
