package com.boardhub.BoardPi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataAlteracao;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private Usuario criador;

    @Transient
    private long idCriador;

    @OneToMany (mappedBy = "projeto", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MembroProjeto> membros;

    @OneToMany (mappedBy = "projeto", fetch = FetchType.LAZY)
    private List<Lista> listas;

    @OneToMany (mappedBy = "projeto", fetch = FetchType.LAZY)
    private List<Prioridade> prioridades;

    public Projeto() {
    }

    public Projeto(Long id, String titulo, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, Usuario criador, List<MembroProjeto> membros, List<Lista> listas, List<Prioridade> prioridades) {
        this.id = id;
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
        this.criador = criador;
        this.membros = membros;
        this.listas = listas;
        this.prioridades = prioridades;
    }

    public Projeto(String titulo, Usuario criador) {
        this.titulo = titulo;
        this.criador = criador;
        this.dataAlteracao = LocalDateTime.now();
        this.dataCriacao = LocalDateTime.now();
        this.membros = new ArrayList<>();
        this.listas = new ArrayList<>();
        this.prioridades = new ArrayList<>();
        setIdCriador();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<MembroProjeto> getMembros() {
        return membros;
    }

    public void setMembros(List<MembroProjeto> membros) {
        this.membros = membros;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    public long getIdCriador() {
        return criador != null? criador.getId() : 0;
    }

    public void setIdCriador() {
        this.idCriador = criador.getId();
    }

    public List<Prioridade> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(List<Prioridade> prioridades) {
        this.prioridades = prioridades;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAlteracao=" + dataAlteracao +
                ", idCriador=" + getIdCriador() +
                ", criador="+criador +
                ", membros=" + membros +
                ", listas=" + listas +
                '}';
    }
}
