package com.GuilhermeAugusto.ListaTarefas.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.GuilhermeAugusto.ListaTarefas.entity.Tarefa;
import com.GuilhermeAugusto.ListaTarefas.repository.TarefaRepositorio;

@Service
public class TarefaServico {
  private TarefaRepositorio tarefaRepositorio;

  public TarefaServico(TarefaRepositorio tarefaRepositorio) {
    this.tarefaRepositorio = tarefaRepositorio;
  }

  public List<Tarefa> criar(Tarefa tarefa) {
    tarefaRepositorio.save(tarefa);
    return listar();
  }

  public List<Tarefa> listar() {
    Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
    return tarefaRepositorio.findAll(sort);
  }

  public List<Tarefa> atualizar(Tarefa tarefa) {
    tarefaRepositorio.save(tarefa);
    return listar();
  }

  public List<Tarefa> deletar(Long id) {
    tarefaRepositorio.deleteById(id);
    return listar();
  }
}
