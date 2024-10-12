package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lista {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private int maxTarefas;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Projeto projeto;

    @Transient
    private long idProjeto;

    public Lista(Long id, String titulo, int maxTarefas, Projeto projeto) {
        this.id = id;
        this.titulo = titulo;
        this.maxTarefas = maxTarefas;
        this.projeto = projeto;
        setIdProjeto();
    }

    public Lista() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getMaxTarefas() {
        return maxTarefas;
    }

    public void setMaxTarefas(int maxTarefas) {
        this.maxTarefas = maxTarefas;
    }


    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto() {
        this.idProjeto = this.projeto != null ? this.projeto.getId() : 0;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", maxTarefas=" + maxTarefas +
                ", idProjeto=" + getIdProjeto() +
                ", projeto=" + projeto +
                '}';
    }
}
