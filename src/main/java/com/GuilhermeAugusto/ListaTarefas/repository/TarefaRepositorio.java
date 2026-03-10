package com.GuilhermeAugusto.ListaTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GuilhermeAugusto.ListaTarefas.entity.Tarefa;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long>{

}
