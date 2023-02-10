package com.example.backend.service;

import com.example.backend.module.Todo;
import com.example.backend.repo.TodoRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {
//create mocks for usage
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

    @Test
    void getTodoById_when_exists_return() {
        //GIVEN
        Todo expected = new Todo("1","test", "OPEN");

        //WHEN
        when(todoRepo.getTodoById("1")).thenReturn(Optional.of(expected));

        Todo actual = todoService.getTodoById("1");

        //THEN
        verify(todoRepo).getTodoById("1");
        assertEquals(expected, actual);

    }

    @Test
    void getTodobyId_throw_exception(){
        //GIVEN
        String id = "404";
        //WHEN
        when(todoRepo.getTodoById(id)).thenThrow(new NoSuchElementException("Menu" + id + "doesn`t exist."));
        //THEN
        assertThrows(NoSuchElementException.class, ()->todoService.getTodoById(id));

    }

    @Test
    void updateTodo() {
        //GIVEN
        String id= "1";
        Todo todoToUpdate = new Todo("1","test", "OPEN");
        Todo expected = new Todo("1","test", "DONE");
        //WHEN
        when(todoRepo.updateTodo(id, todoToUpdate)).thenReturn((expected));
        Todo actual = todoService.updateTodo(id, todoToUpdate);

        //THEN
        verify(todoRepo).updateTodo(id, todoToUpdate);
        assertEquals(expected, actual);
    }


}