package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class EventoDtoOut {

    private Long idEvento;
    private String nome;
    private LocalDate dateGo;
    private LocalDate dateEnd;
    private LocalTime timeGo;
    private LocalTime timeEnd;

    private List<PessoaSimples> escricoes;
    private int arrecadacao;

}
