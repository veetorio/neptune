package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projetos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tematica;

    @ManyToMany
    @JoinTable(
        name="Projetos_Pessoa",
        joinColumns=@JoinColumn(name="fkProjetos"),
        inverseJoinColumns=@JoinColumn(name="fkPessoa")
    )
    private List<Pessoa> inscritos = new ArrayList<>();
}
