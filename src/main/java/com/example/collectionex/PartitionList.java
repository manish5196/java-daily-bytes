package com.example.collectionex;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {

    public static <T> List<List<T>> getBatches(List<T> collection, int batchSize){
        int i = 0;
        List<List<T>> batches = new ArrayList<>();
        while(i<collection.size()){
            int nextInc = Math.min(collection.size()-i, batchSize);
            List<T> batch = collection.subList(i, i + nextInc);
            batches.add(batch);
            i += nextInc;
        }
        return batches;
    }
}
