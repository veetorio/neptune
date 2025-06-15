package com.example.api.controller.dtos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjetoDtoOut {
    private Long id;
    private String nome;
    private String tematica;
    private List<PessoaSimples> inscritos;

}
