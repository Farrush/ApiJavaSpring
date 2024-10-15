package com.boardhub.BoardPi.repositories;

import com.boardhub.BoardPi.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
