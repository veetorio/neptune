package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EventoDtoUpdateOut {
    private Long idEvento;
    private String nome;
    private LocalDate dateGo;
    private LocalDate dateEnd;
    private LocalTime timeGo;
    private LocalTime timeEnd;

    private int arrecadacao;
    private int investido;

}
