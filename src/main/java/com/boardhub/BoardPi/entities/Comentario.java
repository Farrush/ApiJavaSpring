package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comentario {
    @Id
    private Long id;

    @Column
    private String conteudo;

    @ManyToOne
    @JoinColumn
    private Tarefa tarefa;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime comentadoEm;

    @ManyToOne
    @JoinColumn
    private Usuario criador;

    public Comentario() {
    }

    public Comentario(Long id, String conteudo, Tarefa tarefa, LocalDateTime comentadoEm, Usuario criador) {
        this.id = id;
        this.conteudo = conteudo;
        this.tarefa = tarefa;
        this.comentadoEm = comentadoEm;
        this.criador = criador;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public LocalDateTime getComentadoEm() {
        return comentadoEm;
    }

    public void setComentadoEm(LocalDateTime comentadoEm) {
        this.comentadoEm = comentadoEm;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", tarefa=" + tarefa +
                ", comentadoEm=" + comentadoEm +
                ", criador=" + criador +
                '}';
    }
}
