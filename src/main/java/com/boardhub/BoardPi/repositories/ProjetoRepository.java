package com.boardhub.BoardPi.repositories;

import com.boardhub.BoardPi.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    Optional<Projeto> findById(Long id);
    List<Projeto> findAll();
    List<Projeto> findByDataDeAlteracao(Date dataAlteracao);
    List<Projeto> findByTitulo(String titulo);
    List<Projeto> findByDataDeCriacao(Date dataCriacao);
}
