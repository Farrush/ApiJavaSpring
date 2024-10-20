package com.boardhub.BoardPi.repositories;

import com.boardhub.BoardPi.entities.Lista;
import com.boardhub.BoardPi.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    public List<Tarefa> findByLista(Lista lista);
}
