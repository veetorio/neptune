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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Projetos> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projetos> projetos) {
        this.projetos = projetos;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isAtividade() {
        return atividade;
    }

    public void setAtividade(boolean atividade) {
        this.atividade = atividade;
    }


    
}
