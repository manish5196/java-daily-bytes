package com.example.algorithms.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchThroughRecursionTest {

    private BinarySearchThroughRecursion sut;
    int [] elements = {1, 2, 4, 5, 6, 8};
    @BeforeEach
    public void setUp() {
        sut = new BinarySearchThroughRecursion();
    }

    @Test
    public void shouldReturnTrueIfValueInList() {
        assertTrue(sut.search(elements, 5));
    }

    @Test
    public void shouldReturnFalseIfValueInList() {
        assertFalse(sut.search(elements, 10));
    }

    @Test
    public void shouldReturnFalseIfListEmpty() {
        assertFalse(sut.search(new int[0], 10));
    }
}
