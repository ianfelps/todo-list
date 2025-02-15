package com.ianfelps.todo_list.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ianfelps.todo_list.entity.Todo;
import com.ianfelps.todo_list.service.TodoService;
import jakarta.validation.Valid;

// Controlador para manipulação da entidade To-do via API.
@RestController
@RequestMapping("/api")
public class TodoApiController {
    // Serviço para manipulação da entidade To-do.
    private TodoService todoService;

    // Construtor do controlador.
    public TodoApiController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Endpoint para listar todos os To-dos.
    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }
    
    // Endpoint para criar um To-do.
    @PostMapping
    ResponseEntity<List<Todo>> create(@Valid @RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(todoService.create(todo));
    }

    // Edpoint para atualizar um To-do.
    @PutMapping("{id}")
    List<Todo> update(@PathVariable("id") Long id, @Valid @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    // Endpoint para deletar um To-do.
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}
