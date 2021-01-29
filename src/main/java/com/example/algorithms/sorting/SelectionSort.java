package com.example.algorithms.sorting;

import com.example.functional.component.IntBiPredicate;

public class SelectionSort {

    public void sort(int[] elements, IntBiPredicate predicate) {
        for (int i = 0; i < elements.length; i++) {
            int index = i;
            for (int j = i + 1; j < elements.length; j++) {
                if(predicate.testAsInt(elements[j], elements[index])) {
                    index = j;
                }
            }
            int temp = elements[index];
            elements[index] = elements[i];
            elements[i] = temp;
        }
    }
}
