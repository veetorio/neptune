
package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class PessoaDtoOut {
    private Long id;
    
    private int idade;

    private String local;

    private String nome;

    private boolean atividade;

    private LocalDate nascimento;

    private List<EventoDtoOut> eventos;
}
