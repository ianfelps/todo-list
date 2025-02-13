package com.ianfelps.todo_list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.ianfelps.todo_list.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class TodoListApplicationTests {

	// Injeção de dependência.
	@Autowired
	private WebTestClient webTestClient;

	// Teste para verificação de sucesso na criação de um To-do.
	@Test
	@Order(1)
	void testCreateTodoSuccess() {
		// Criando um novo To-do.
		var todo = new Todo("todo 1", "desc todo 1", false, 1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());

		// Setando o ID do To-do criado para ser utilizado nos demais testes.
		todo.setId(1L);
	}

	// Teste para verificação de falha na criação de um To-do.
	@Test
	@Order(2)
	public void testCreateTodoFailure() {
		// Criando um objeto inválido (nome e descrição vazios, prioridade inválida).
		var todo = new Todo("", "", false, -1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isBadRequest();
	}

	// Teste para verificação de sucesso na atualização de um To-do.
	@Test
	@Order(3)
	public void testUpdateTodoSuccess() {
		// Criando um novo objeto atualizado.
		var updatedTodo = new Todo(1L, "todo 1 put", "desc todo 1 put", true, 0);

		webTestClient
				.put()
				.uri("/todos/" + updatedTodo.getId())
				.bodyValue(updatedTodo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(updatedTodo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(updatedTodo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(updatedTodo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(updatedTodo.getPrioridade());
	}

	// Teste para verificação de falha na atualização de um To-do.
	@Test
	@Order(4)
	public void testUpdateTodoFailure() {
		// Criando um objeto inválido (nome e descrição vazios, prioridade inválida).
		var invalidTodo = new Todo(1L, "", "", true, -1);

		webTestClient
				.put()
				.uri("/todos/" + invalidTodo.getId())
				.bodyValue(invalidTodo)
				.exchange()
				.expectStatus().isBadRequest();
	}

	// Teste para verificação de sucesso na exclusão de um To-do.
	@Test
	@Order(5)
	public void testDeleteTodoSuccess() {
		// Chamando o DELETE para remover o Todo.
		webTestClient
				.delete()
				.uri("/todos/" + 1)
				.exchange()
				.expectStatus().isOk();

		// Verificando se o Todo foi realmente deletado.
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(0);
	}
}
