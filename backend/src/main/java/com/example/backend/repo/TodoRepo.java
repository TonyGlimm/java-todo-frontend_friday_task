package com.example.backend.repo;

import com.example.backend.module.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository

public class TodoRepo {
    private final List<Todo> todoList;


    public TodoRepo(List<Todo> todoList){
        this.todoList = todoList;
    }

    public Todo addTodo(Todo todo){
        todoList.add(todo);
        return todo;
    }

    public List<Todo> getTodoList(){
        return todoList;
    }

    public Optional<Todo> getTodoById(String id){
        return todoList.stream().filter(todo -> todo.id().equals(id)).findFirst();
    }

    public  Todo updateTodo(String id , Todo todo)
    {
        Todo todoToReplace = getTodoById(id).orElseThrow(NoSuchElementException::new);
        todoList.remove(todoToReplace);
        todoList.add(todo);
        return todo;
    }

    public void deleteTodo(String id){
        Todo todoToDelete = getTodoById(id).orElseThrow(NoSuchElementException::new);
        todoList.remove(todoToDelete);
    }
}
