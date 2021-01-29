package com.example.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    int [] elements = {1, 3, 5, 7, 8, 10, 2};


    SelectionSort sut;
    @BeforeEach
    public void setup() {
        sut = new SelectionSort();
    }

    @Test
    public void testSortAsc() {
        sut.sort(elements, ( i,  j) -> i < j);
        int [] result = {1, 2, 3, 5, 7, 8, 10};
        assertArrayEquals(result, elements);
    }

    @Test
    public void testSortDesc() {
        sut.sort(elements, ( i,  j) -> i > j);
        int [] result = {10, 8, 7, 5, 3, 2, 1};
        assertArrayEquals(result, elements);
    }
}
