package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tarefa {
    @Id
    private Long id;

    @Column(nullable = false)
    private String objetivo;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Usuario criador;

    @Transient
    private long idCriador;

    @ManyToOne
    @JoinColumn
    private Usuario responsavel;

    @Transient
    private long idResponsavel;

    @ManyToOne
    @JoinColumn
    private Lista lista;

    @OneToOne
    @JoinColumn
    private Prioridade tagPrioridade;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime prazo;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataAlteracao;

    public Tarefa() {
    }

    public Tarefa(Long id, String objetivo, Usuario criador, Usuario responsavel, Prioridade tagPrioridade, LocalDateTime prazo, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, Lista lista ) {
        this.id = id;
        this.objetivo = objetivo;
        this.criador = criador;
        this.responsavel = responsavel;
        this.tagPrioridade = tagPrioridade;
        this.prazo = prazo;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
        this.lista = lista;
        setIdCriador();
        setIdResponsavel();
    }

    public Tarefa(Long id, String objetivo, Usuario criador, Usuario responsavel, Prioridade tagPrioridade, Lista lista) {
        this.id = id;
        this.objetivo = objetivo;
        this.criador = criador;
        this.responsavel = responsavel;
        this.tagPrioridade = tagPrioridade;
        this.prazo = null;
        this.dataCriacao = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
        this.lista = lista;
        setIdCriador();
        setIdResponsavel();
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getTagPrioridade() {
        return tagPrioridade;
    }

    public void setTagPrioridade(Prioridade tagPrioridade) {
        this.tagPrioridade = tagPrioridade;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public long getIdCriador() {
        return idCriador;
    }

    public void setIdCriador() {
        this.idCriador = criador != null ? criador.getId() : 0;
    }

    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel() {
        this.idResponsavel = responsavel != null ? responsavel.getId():0;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", objetivo='" + objetivo + '\'' +
                ", criador=" + criador +
                ", responsavel=" + responsavel +
                ", idCriador=" + getIdCriador() +
                ", idResponsavel=" + getIdResponsavel() +
                ", tagPrioridade=" + tagPrioridade +
                ", prazo=" + prazo +
                ", dataCriacao=" + dataCriacao +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
