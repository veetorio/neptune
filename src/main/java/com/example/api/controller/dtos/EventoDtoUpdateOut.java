package com.example.api.controller.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EventoDtoUpdateOut {
    private Long idEvento;
    private String nome;
    private LocalDate dateGo;
    private LocalDate dateEnd;
    private LocalTime timeGo;
    private LocalTime timeEnd;

    private int arrecadacao;
    private int investido;

    public int getInvestido(){
        return this.investido;
    }
    public void setInvestido(int investido){
        this.investido = investido;
    }
    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDateGo() {
        return dateGo;
    }

    public void setDateGo(LocalDate dateGo) {
        this.dateGo = dateGo;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalTime getTimeGo() {
        return timeGo;
    }

    public void setTimeGo(LocalTime timeGo) {
        this.timeGo = timeGo;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public float getArrecadacao() {
        return arrecadacao;
    }


}
