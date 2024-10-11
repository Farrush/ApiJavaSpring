package com.boardhub.BoardPi.resources;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/projeto")
public class ProjetoResource {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        return projetoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        return ResponseEntity.ok(projetoService.findAll());
    }

    @GetMapping("/data-alteracao")
    public ResponseEntity<List<Projeto>> getProjetosByDataAlteracao(@RequestParam Date dataAlteracao) {
        return ResponseEntity.ok(projetoService.findByDataDeAlteracao(dataAlteracao));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Projeto>> getProjetosByTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    @GetMapping("/data-criacao")
    public ResponseEntity<List<Projeto>> getProjetosByDataCriacao(@RequestParam Date dataCriacao) {
        return ResponseEntity.ok(projetoService.findByDataCriacao(dataCriacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody String titulo) {
        return ResponseEntity.ok(projetoService.updateProjeto(id, titulo));
    }
}
