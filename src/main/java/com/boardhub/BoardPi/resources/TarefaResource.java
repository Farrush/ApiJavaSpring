package com.boardhub.BoardPi.resources;


import com.boardhub.BoardPi.entities.Tarefa;
import com.boardhub.BoardPi.services.ListaService;
import com.boardhub.BoardPi.services.TarefaService;
import com.boardhub.BoardPi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tarefa")
public class TarefaResource {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private ListaService listaService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Tarefa> listarTodos() {
        return tarefaService.getTarefas();
    }

    @RequestMapping(value = "/{id}")
    public Tarefa buscaPorId(@PathVariable long id) {
        return tarefaService.getTarefa(id);
    }

    @RequestMapping(value = "/lista/{idLista}/criador/{idCriador}", method = RequestMethod.POST)
    public Tarefa adicionar(@PathVariable long idLista, @PathVariable long idCriador, @RequestBody Tarefa tarefa) {
        tarefa.setLista(listaService.getLista(idLista));
        tarefa.setCriador(usuarioService.getUsuario(idCriador));
        return tarefaService.addTarefa(tarefa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Tarefa alterar(@PathVariable long id, @RequestBody Tarefa tarefa){
        tarefa.setId(id);
        return tarefaService.updateTarefa(tarefa);
    }
    @RequestMapping(value = "/{id}/responsavel/{idResponsavel}", method = RequestMethod.PUT)
    public Tarefa alterar(@PathVariable long id, @PathVariable long idResponsavel, @RequestBody Tarefa tarefa){
        tarefa.setId(id);
        tarefa.setResponsavel(usuarioService.getUsuario(idResponsavel));
        return tarefaService.updateTarefa(tarefa);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remover(@PathVariable long id) {
        Tarefa t = tarefaService.getTarefa(id);
        if(t != null){
            tarefaService.deleteTarefa(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
