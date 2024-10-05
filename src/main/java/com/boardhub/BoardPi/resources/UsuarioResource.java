package com.boardhub.BoardPi.resources;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Usuario;
import com.boardhub.BoardPi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @RequestMapping(value = "/{id}")
    public Usuario getUsuario(@PathVariable() long id){
        return usuarioService.getUsuario(id);
    }
    @RequestMapping(value = "/{id}/projetos")
    public List<Projeto> getProjetos(@PathVariable(value = "id") long id){
        try{
            Usuario u = usuarioService.getUsuario(id);
            List<Projeto> lp =  usuarioService.getProjetos(u);
            return lp;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @RequestMapping(value = "/{id}/projetos/participando")
    public List<Projeto> getProjetoParticipando(@PathVariable() long id){
        try{
            Usuario u = usuarioService.getUsuario(id);
            List<Projeto> lp =  usuarioService.getProjetosParticipados(u);
            return lp;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
