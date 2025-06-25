
package com.example.api.controller.dtos;

import java.time.LocalDate;

import com.example.api.model.Pessoa;

import lombok.Data;


@Data // Opcional: se precisar de construtor com todos os campos
public class PessoaDtoOut {
    private Long id;

    private String local;

    private String nome;

    private boolean atividade;

    private LocalDate nascimento;

    private int idade;


}
