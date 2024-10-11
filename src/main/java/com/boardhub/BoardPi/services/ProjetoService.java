package com.boardhub.BoardPi.services;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public List<Projeto> findByTitulo(String titulo) {
        return projetoRepository.findByTitulo(titulo);
    }

    public Projeto updateProjeto(Long id, String titulo) {
        Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();
            projeto.setTitulo(titulo);
            return projetoRepository.save(projeto);
        }
        return null;
    }
}
