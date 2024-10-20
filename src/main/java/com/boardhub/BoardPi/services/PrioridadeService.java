package com.boardhub.BoardPi.services;

import com.boardhub.BoardPi.entities.Prioridade;
import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.repositories.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadeService {

    @Autowired
    private PrioridadeRepository prioridadeRepository;
    public List<Prioridade> getPrioridades() {
        return prioridadeRepository.findAll();
    }
    public Prioridade getPrioridade(long id) {
        return prioridadeRepository.findById(id).orElse(null);
    }
    public Prioridade addPrioridade(Prioridade prioridade) {
        return prioridadeRepository.save(prioridade);
    }
    public Prioridade updatePrioridade(Prioridade prioridade) {
        return prioridadeRepository.save(prioridade);
    }
    public void deletePrioridade(long id) {
        prioridadeRepository.deleteById(id);
    }
    public List<Prioridade> getPorProjeto(Projeto projeto) {
        return prioridadeRepository.findByProjeto(projeto);
    }
}
