package com.ianfelps.todo_list.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianfelps.todo_list.entity.Todo;
import com.ianfelps.todo_list.service.TodoService;

// Controlador para manipulação da entidade To-do via interface web.
@Controller
@RequestMapping("/")
public class TodoWebController {
    // Serviço para manipulação da entidade To-do.
    private final TodoService todoService;

    // Construtor do controlador.
    public TodoWebController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Página inicial com a lista de To-dos
    @GetMapping
    public String list(Model model) {
        List<Todo> todos = todoService.list();
        model.addAttribute("todos", todos);
        return "index";
    }
}
