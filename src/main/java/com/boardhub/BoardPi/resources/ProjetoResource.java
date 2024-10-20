package com.boardhub.BoardPi.resources;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.services.ProjetoService;
import com.boardhub.BoardPi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/projeto")
public class ProjetoResource {

    @Autowired
    private ProjetoService projetoService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(projetoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        return ResponseEntity.ok(projetoService.findAll());
    }


    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Projeto>> getProjetosByTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    @RequestMapping(value = "/criador/{id}", method = RequestMethod.POST)
    public Projeto adicionar(@PathVariable long id, @RequestBody Projeto projeto) {
        projeto.setCriador(usuarioService.getUsuario(id));
        return projetoService.addProjeto(projeto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Projeto alterar(@PathVariable long id, @RequestBody Projeto projeto){
        Projeto p = projetoService.findById(id);
        p.setTitulo(projeto.getTitulo());
        p.setDataAlteracao(projeto.getDataAlteracao());
        projetoService.updateProjeto(p);
        return p;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remover(@PathVariable long id) {
        Projeto p = projetoService.findById(id);
        if(p != null){
            projetoService.deleteProjeto(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
