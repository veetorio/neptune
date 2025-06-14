package com.example.api.model;

import java.time.LocalDateTime;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Nullable
    @ManyToMany(mappedBy="escricao")
    private List<Evento> evento;

    private LocalDateTime nascimento;

    private int idade;

    private String local;

    private boolean atividade;
    
}
