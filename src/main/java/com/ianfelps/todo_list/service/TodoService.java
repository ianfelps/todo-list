package com.ianfelps.todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ianfelps.todo_list.entity.Todo;
import com.ianfelps.todo_list.repository.TodoRepository;

// Serviço para manipulação da entidade To-do.
@Service
public class TodoService {
    
    // Repositório da entidade To-do.
    private TodoRepository todoRepository;

    // Construtor da classe TodoService.
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Método para listar todos os To-dos.
    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("id").ascending());

        return todoRepository.findAll(sort);
    }

    // Método para criar um To-do.
    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);

        return list();
    }

    // Método para atualizar um To-do.
    public List<Todo> update(Long id, Todo todo) {
        todo.setId(id);
        todoRepository.save(todo);

        return list();
    }

    // Método para deletar um To-do.
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);

        return list();
    }

}
