package com.boardhub.BoardPi.entities;

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

    @OneToMany (mappedBy = "lista")
    private List<Tarefa> tarefas;

    @ManyToOne
    @JoinColumn
    private Projeto projeto;

    public Lista(Long id, String titulo, int maxTarefas, List<Tarefa> tarefas, Projeto projeto) {
        this.id = id;
        this.titulo = titulo;
        this.maxTarefas = maxTarefas;
        this.tarefas = tarefas;
        this.projeto = projeto;
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

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
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

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", maxTarefas=" + maxTarefas +
                ", tarefas=" + tarefas +
                ", projeto=" + projeto +
                '}';
    }
}
