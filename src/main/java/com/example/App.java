package com.example;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        int i = 0;
        int batchSize = 2;
        List<List<Integer>> batch = new ArrayList<>();
        while (i < ids.size()) {
            int nextInc = Math.min(ids.size() - i, batchSize);
            batch.add(ids.subList(i, i + nextInc));
            i = i + nextInc;
        }

        System.out.println(batch);
    }
}

