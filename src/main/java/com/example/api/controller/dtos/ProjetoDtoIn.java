package com.example.api.controller.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Lombok: gera getters
@Setter // Lombok: gera setters
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjetoDtoIn {
    private String nome;
    private String tematica;
}
