package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Projeto projeto;

    @Transient
    private long idProjeto;

    @Column
    private String prioridade;

    @Column
    private String cor;

    public Prioridade(Long id, Projeto projeto, String prioridade, String cor) {
        this.id = id;
        this.projeto = projeto;
        this.prioridade = prioridade;
        this.cor = cor;
        setIdProjeto();
    }
    public Prioridade() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto() {
        this.idProjeto = projeto != null ? projeto.getId() : 0;
    }

    @Override
    public String toString() {
        return "Prioridade{" +
                "id=" + id +
                ", projeto=" + projeto +
                ", idProjeto=" + getIdProjeto() +
                ", prioridade='" + prioridade + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
