package com.GuilhermeAugusto.ListaTarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GuilhermeAugusto.ListaTarefas.entity.Tarefa;
import com.GuilhermeAugusto.ListaTarefas.service.TarefaServico;

@RestController
@RequestMapping("/tarefas")
public class TarefaControlador {
  private TarefaServico tarefaServico;

  public TarefaControlador(TarefaServico tarefaServico) {
    this.tarefaServico = tarefaServico;
  }

  @PostMapping
  List<Tarefa> criar(@RequestBody Tarefa tarefa) {
    return tarefaServico.criar(tarefa);
  }

  @GetMapping
  List<Tarefa> listar() {
    return tarefaServico.listar();
  }

  @PutMapping
  List<Tarefa> atualizar(@RequestBody Tarefa tarefa) {
    return tarefaServico.atualizar(tarefa);
  }

  @DeleteMapping("{id}")
  List<Tarefa> deletar(@PathVariable("id") Long id) {
    return tarefaServico.deletar(id);
  }

}
