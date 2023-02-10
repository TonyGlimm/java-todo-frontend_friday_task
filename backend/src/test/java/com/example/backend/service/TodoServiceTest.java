package com.example.backend.service;

import com.example.backend.module.Todo;
import com.example.backend.repo.TodoRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    TodoRepo todoRepo =mock(TodoRepo.class);
    IdService idService = mock(IdService.class);
    TodoService todoService = new TodoService(todoRepo, idService);


    @Test
    void getAllTodos_whenListIsEmpty_ReturnEmptyList() {
        //GIVEN
        List<Todo> expected = Collections.emptyList();
        //WHEN
        when(todoRepo.getTodoList()).thenReturn(Collections.emptyList());

        List<Todo> actual = todoService.getAllTodos();
        //THEN
        verify(todoRepo).getTodoList();
        assertEquals(expected, actual);
    }

    @Test
    void addTodo() {
        //GIVEN
        Todo expected = new Todo("1","test", "OPEN");
        //WHEN
        when(todoRepo.addTodo(expected)).thenReturn(expected);
        when(idService.generateId()).thenReturn("1");
        Todo actual = todoService.addTodo(expected);
        //THEN
        verify(todoRepo).addTodo(expected);
        assertEquals(expected, actual);
    }
}