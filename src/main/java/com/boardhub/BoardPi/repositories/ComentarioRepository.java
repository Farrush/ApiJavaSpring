package com.boardhub.BoardPi.repositories;

import com.boardhub.BoardPi.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
