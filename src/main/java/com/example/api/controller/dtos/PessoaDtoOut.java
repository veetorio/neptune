
package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Data
public class PessoaDtoOut {
    private Long id;
    
    private int idade;

    private String local;

    private String nome;

    private boolean atividade;

    private LocalDate nascimento;

    private List<EventoDtoOut> eventos;
}
