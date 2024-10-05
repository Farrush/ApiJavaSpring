package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
public class MembroProjeto {
    public static final int MEMBRO = 0;
    public static final int ADMIN = 1;
    public static final int OBSERVADOR = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private long idMembro;

    @Transient
    private long idProjeto;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Projeto projeto;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Usuario membro;

    private int nivelAutoridade;

    public MembroProjeto(Long id, Projeto projeto, Usuario membro, int nivelAutoridade) {
        this.id = id;
        this.projeto = projeto;
        this.membro = membro;
        this.nivelAutoridade = nivelAutoridade;
        this.idProjeto = projeto.getId();
        this.idMembro = membro.getId();
    }

    public MembroProjeto() {

    }

    public MembroProjeto(Projeto projeto, Usuario membro, int nivelAutoridade) {
        this.projeto = projeto;
        this.membro = membro;
        this.nivelAutoridade = nivelAutoridade;
        this.idProjeto = projeto.getId();
        this.idMembro = membro.getId();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Usuario getMembro() {
        return membro;
    }

    public void setMembro(Usuario membro) {
        this.membro = membro;
    }

    public int getNivelAutoridade() {
        return nivelAutoridade;
    }

    public void setNivelAutoridade(int nivelAutoridade) {
        if(nivelAutoridade < 0 || nivelAutoridade > 2){
            nivelAutoridade = 0;
        }
        this.nivelAutoridade = nivelAutoridade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getIdMembro() {
        return membro != null ? membro.getId() : 0;
    }

    public void setIdMembro(long idMembro) {
        this.idMembro = idMembro;
    }

    public long getIdProjeto() {
        return projeto != null ? projeto.getId() : 0;
    }

    public void setIdProjeto(long idProjeto) {
        this.idProjeto = idProjeto;
    }

    @Override
    public String toString() {
        return "MembroProjeto{" +
                "id=" + id +
                ", idMembro=" + getIdMembro() +
                ", idProjeto=" + getIdProjeto() +
                ", projeto=" + projeto +
                ", membro=" + membro +
                ", nivelAutoridade=" + nivelAutoridade +
                '}';
    }
}
