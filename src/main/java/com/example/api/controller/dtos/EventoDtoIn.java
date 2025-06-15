package com.example.api.controller.dtos;

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

    private float investido;
    private float arrecadacao;
}
