package com.example.backend.service;

import com.example.backend.module.Todo;
import com.example.backend.repo.TodoRepo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final IdService idService;

//    @Autowired
    public TodoService(TodoRepo todoRepo, IdService idService){
        this.todoRepo = todoRepo;
        this.idService = idService;
    }



    public Todo addTodo(Todo todo){
        Todo todoToAdd = new Todo(
              idService.generateId(),
                todo.description(),
                todo.status()
        );
        return todoRepo.addTodo(todoToAdd);
    }

    public List<Todo> getAllTodos(){
        return todoRepo.getTodoList();
    }

    public Todo getTodoById(String id){
        return todoRepo.getTodoById(id)
                .orElseThrow(NoSuchElementException::new);
    }

}
