package com.boardhub.BoardPi.services;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.entities.Usuario;
import com.boardhub.BoardPi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    /*Fazer: Crud de usuário - feito
    * Busca de usuário por id - feito
    * Busca de projetos do usuário (dono) (id/projetos) - feito
    * Busca de projetos que o usuário é membro (id/projetos/participando) - feito
    * Busca de tarefas que são de responsabilidade do usuário (id/tarefas) - feito mas precisa testar direito
    * Testar - A fazer
    * */

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuario(long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public void deleteUsuario(long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public List<Projeto> getProjetos(Usuario usuario){
        return usuarioRepository.findProjectsByUsuario(usuario);
    }
    public List<Projeto> getProjetosParticipados(Usuario usuario){
        return usuarioRepository.findProjectsByMembro(usuario);
    }
    public List<Tarefa> getTarefas(Usuario usuario, Projeto projeto){
        return usuarioRepository.findTarefasByUsuarioAndProjeto(usuario, projeto);
    }
}
