package com.example.api.controller.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
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
