package com.example.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEvento;

    @Column(name="nome_do_evento")
    private String nome;
    @Column(name="data_de_Inicio")
    private LocalDate dateGo;
    @Column(name="data_de_termino")
    private LocalDate dateEnd;
    @Column(name="horario_de_inicio")
    private LocalTime timeGo;
    @Column(name="horario_de_termino")
    private LocalTime timeEnd;

    private BigDecimal arrecadacao; // em centavos 
    private BigDecimal investido; // em centavos
    private boolean atividade;

    @Nullable
    @ManyToMany
    @JoinTable(
        name="pessoa_eventos",
        joinColumns = @JoinColumn(name="FkEvento"),
        inverseJoinColumns = @JoinColumn(name="FkPessoa")
    )
    private List<Pessoa> escricoes = new ArrayList<Pessoa>();


}
