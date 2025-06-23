package com.example.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;
    
    @Nullable
    @ManyToMany(mappedBy="escricoes")
    private List<Evento> eventos = new ArrayList<Evento>();

    @Nullable
    @ManyToMany(mappedBy="inscritos")
    private List<Projetos> projetos = new ArrayList<Projetos>();

    private LocalDate nascimento;

    private String local;

    private boolean atividade;
}
