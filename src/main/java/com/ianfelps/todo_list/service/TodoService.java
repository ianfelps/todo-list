package com.ianfelps.todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ianfelps.todo_list.entity.Todo;
import com.ianfelps.todo_list.repository.TodoRepository;

@Service
public class TodoService {
    
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("id").ascending());

        return todoRepository.findAll(sort);
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);

        return list();
    }

    public List<Todo> update(Long id, Todo todo) {
        todo.setId(id);
        todoRepository.save(todo);

        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);

        return list();
    }

}
