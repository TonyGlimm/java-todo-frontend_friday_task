package com.example.backend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdServiceTest {

    IdService idService = new IdService();
    @Test
    void generateId() {
        assertNotNull(idService.generateId());
    }
}