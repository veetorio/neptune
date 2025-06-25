package com.example.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.api.controller.dtos.PessoaDtoIn;
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
    
    @ManyToMany(mappedBy="escricoes")
    private List<Evento> eventos = new ArrayList<Evento>();

    @ManyToMany(mappedBy="inscritos")
    private List<Projeto> projetos = new ArrayList<Projeto>();

    private LocalDate nascimento;

    private String local;

    private boolean atividade;


}
