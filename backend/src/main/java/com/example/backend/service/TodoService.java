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
              idService.generateId(), //wanted to try out uuid since i didnt yesterday. it worked, URL`s look awful though
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
                .orElseThrow(NoSuchElementException::new); //found this syntax online, no idea yet how it works or why but seems to work
    }

    public Todo updateTodo(String id, Todo todo){
        Todo todoToUpdate = new Todo(
                id,
                todo.description(),
                todo.status()
        );
        return todoRepo.updateTodo(id, todoToUpdate);
    }

    public void deleteTodo(String id){
        todoRepo.deleteTodo(id);
    }

}
