package com.boardhub.BoardPi.repositories;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("select p from Projeto p where p.criador = :u")
    public List<Projeto> findProjectsByUsuario(Usuario u);

    @Query("select p from Projeto p inner join MembroProjeto mp on mp.membro = :u where mp.projeto = p")
    public List<Projeto> findProjectsByMembro(Usuario u);

    @Query("select t from Tarefa t inner join Lista l on l.projeto = :p where t.responsavel = :u")
    public List<Tarefa> findTarefasByUsuarioAndProjeto(Usuario u, Projeto p);

    @Query("select u.id, u.email from Usuario u where u.email = :email and u.senha = :senha")
    public Long validateUser(String email, String senha);

    @Modifying
    @Query("delete from MembroProjeto m where m.membro = :usuario")
    public void deleteUsuarioDeMembro(Usuario usuario);

    @Modifying
    @Query(value = "delete from Comentario c where c.criador = :usuario")
    public void deleteComentarios(Usuario usuario);

    @Modifying
    @Query("update Tarefa t set t.criador = null where t.criador = :usuario")
    public void updateTarefaDoUsuario(Usuario usuario);

    @Modifying
    @Query("update Tarefa t set t.responsavel = null where t.responsavel = :usuario")
    public void updateResponsabilidadeDoUsuario(Usuario usuario);

    @Modifying
    @Query("update Projeto p set p.criador = null where p.criador = :usuario")
    public void updateCriador(Usuario usuario);
}
