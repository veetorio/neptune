package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PUBLIC) 
@AllArgsConstructor // Opcional: se precisar de construtor com todos os campos
public class EventoDtoOut {

    private Long idEvento;
    private String nome;
    private LocalDate dateGo;
    private LocalDate dateEnd;
    private LocalTime timeGo;
    private LocalTime timeEnd;

    private List<PessoaSimples> escricoes;
    private int arrecadacao;
    private int investido;

}
