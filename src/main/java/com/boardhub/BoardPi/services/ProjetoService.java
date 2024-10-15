package com.boardhub.BoardPi.services;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto findById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public List<Projeto> findByTitulo(String titulo) {
        return projetoRepository.findByTitulo(titulo);
    }

    public Projeto addProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
    public Projeto updateProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
    public void deleteProjeto(long id) {
        projetoRepository.deleteById(id);
    }
}
