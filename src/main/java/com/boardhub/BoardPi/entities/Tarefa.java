package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Usuario criador;

    @ManyToOne
    @JoinColumn
    private Usuario responsavel;

    @ManyToOne
    @JoinColumn
    private Lista lista;

    @OneToMany (mappedBy = "tarefa")
    private List<Comentario> comentarios;

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

    public Tarefa(Long id, String objetivo, Usuario criador, Usuario responsavel, List<Comentario> comentarios, Prioridade tagPrioridade, LocalDateTime prazo, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, Lista lista ) {
        this.id = id;
        this.objetivo = objetivo;
        this.criador = criador;
        this.responsavel = responsavel;
        this.comentarios = comentarios;
        this.tagPrioridade = tagPrioridade;
        this.prazo = prazo;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
        this.lista = lista;
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
        this.comentarios = new ArrayList<>();
        this.lista = lista;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", objetivo='" + objetivo + '\'' +
                ", criador=" + criador +
                ", responsavel=" + responsavel +
                ", comentarios=" + comentarios +
                ", tagPrioridade=" + tagPrioridade +
                ", prazo=" + prazo +
                ", dataCriacao=" + dataCriacao +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
