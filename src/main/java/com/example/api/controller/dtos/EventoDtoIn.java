package com.example.api.controller.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@AllArgsConstructor // Opcional: se precisar de construtor com todos os campos
@NoArgsConstructor(access = AccessLevel.PUBLIC) 
public class EventoDtoIn {
    private String nome;
    private LocalDate dateGo;
    private LocalDate dateEnd;
    private LocalTime timeGo;
    private LocalTime timeEnd;
    private boolean atividade;

    private BigDecimal investido;
    private BigDecimal arrecadacao;
}
