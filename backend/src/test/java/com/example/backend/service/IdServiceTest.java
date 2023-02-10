package com.example.backend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdServiceTest {

    IdService idService = new IdService();
    @Test
    void generateId() {
        assertNotNull(idService.generateId()); //found this method. no idea on how to test randomness of function otherwise then not null
    }
}