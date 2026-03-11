package com.GuilhermeAugusto.ListaTarefas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.GuilhermeAugusto.ListaTarefas.entity.Tarefa;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ListaTarefasApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testeCriarListaTarefasSucesso() throws Exception {

		var tarefa = new Tarefa("tarefa 1", "desc tarefa 1", false, 1);

		mockMvc
		.perform(post("/tarefas").contentType("application/json").content(objectMapper.writeValueAsString(tarefa)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$.length()").value(1))
		.andExpect(jsonPath("$[0].nome").value(tarefa.getNome()))
		.andExpect(jsonPath("$[0].descricao").value(tarefa.getDescricao()))
		.andExpect(jsonPath("$[0].realizado").value(tarefa.isRealizado()))
		.andExpect(jsonPath("$[0].prioridade").value(tarefa.getPrioridade()));
	}

	@Test
	void testeCriarListaTarefasFalha() throws Exception {
		mockMvc
			.perform(post("/tarefas")
			.contentType("application/json")
			.content("{\"nome\":\"\",\"descricao\":\"\",\"realizado\":false,\"prioridade\":null}"))
			.andExpect(status().isBadRequest());
	}

}
