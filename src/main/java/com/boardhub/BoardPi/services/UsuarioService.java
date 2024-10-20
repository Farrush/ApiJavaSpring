package com.boardhub.BoardPi.services;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.entities.Usuario;
import com.boardhub.BoardPi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuario(long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deleteUsuario(Usuario u){
        //usuarioRepository.deleteUsuarioDeMembro(u);
        //usuarioRepository.deleteComentarios(u);
        //usuarioRepository.updateCriador(u);
        usuarioRepository.updateTarefaDoUsuario(u);
        usuarioRepository.updateResponsabilidadeDoUsuario(u);
        usuarioRepository.deleteById(u.getId());
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
    public boolean validaUsuario(String email, String senha){
        return usuarioRepository.validateUser(email, senha) >= 0L;
    }
}
