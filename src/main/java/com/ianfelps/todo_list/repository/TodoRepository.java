package com.ianfelps.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ianfelps.todo_list.entity.Todo;

// Interface de repositório para a entidade To-do (Conexão com o banco).
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
