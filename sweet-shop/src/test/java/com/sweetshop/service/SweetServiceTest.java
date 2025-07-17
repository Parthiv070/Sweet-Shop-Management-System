package com.sweetshop.service;

import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SweetServiceTest {

    private SweetRepository sweetRepository;
    private SweetService sweetService;

    @BeforeEach
    void setup() {
        sweetRepository = mock(SweetRepository.class);
        sweetService = new SweetService(sweetRepository);
    }

    @Test
    void testAddSweet() {
        Sweet sweet = new Sweet(0L, "Ladoo", "Milk", 10.0, 50);
        Sweet saved = new Sweet(1L, "Ladoo", "Milk", 10.0, 50);

        when(sweetRepository.save(sweet)).thenReturn(saved);

        Sweet result = sweetService.addSweet(sweet);
        assertEquals("Ladoo", result.getName());
        assertEquals(50, result.getQuantity());
    }
}
