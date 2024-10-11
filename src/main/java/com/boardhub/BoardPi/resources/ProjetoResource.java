package com.boardhub.BoardPi.resources;

import com.boardhub.BoardPi.entities.Projeto;
import com.boardhub.BoardPi.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
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


    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Projeto>> getProjetosByTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody String titulo) {
        return ResponseEntity.ok(projetoService.updateProjeto(id, titulo));
    }
}
