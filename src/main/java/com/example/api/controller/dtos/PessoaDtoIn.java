package com.example.api.controller.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data // Opcional: se precisar de construtor com todos os campos
public class PessoaDtoIn {

    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd") // aplica só neste campo
    private LocalDate nascimento;

    private boolean atividade;

    private String local;

    private String senha;
}
