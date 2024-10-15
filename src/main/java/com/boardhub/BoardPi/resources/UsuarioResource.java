package com.boardhub.BoardPi.resources;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.entities.Usuario;
import com.boardhub.BoardPi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 36000)
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            if (usuarioService.validaUsuario(usuario.getEmail(), usuario.getSenha())) {
                return ResponseEntity.ok().build();
            } else {
                throw new Exception("Email e senha incorretos");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        try {
            Usuario u = usuarioService.saveUsuario(usuario);
            System.out.println(u);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> deletar(@PathVariable long id) {
        try{
            Usuario u = usuarioService.getUsuario(id);
            usuarioService.deleteUsuario(u);
            return ResponseEntity.ok().body(u);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Usuario alterar(@PathVariable long id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioService.updateUsuario(usuario);
    }
}
