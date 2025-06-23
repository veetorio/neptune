
package com.example.api.controller.dtos;

import java.time.LocalDate;

import com.example.api.model.Pessoa;

import lombok.Data;


@Data // Opcional: se precisar de construtor com todos os campos
public class PessoaDtoOut {
    private Long id;
    
    private int idade;

    private String local;

    private String nome;

    private boolean atividade;

    private LocalDate nascimento;

    public PessoaDtoOut(Pessoa p){
        this.nome = p.getNome();
        this.local = p.getLocal();
        this.atividade = p.isAtividade();
        this.nascimento = p.getNascimento();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtividade() {
        return atividade;
    }

    public void setAtividade(boolean atividade) {
        this.atividade = atividade;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

}
