package com.example.backend.controller;

import com.example.backend.module.Todo;
import com.example.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

//    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public Todo post(@RequestBody Todo inputText)
    {
       return todoService.addTodo(inputText);

    }

    @GetMapping
    public List<Todo> getAllTodos()
    {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoById(id);
    }



}
