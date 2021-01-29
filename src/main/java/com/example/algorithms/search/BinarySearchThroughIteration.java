package com.example.algorithms.search;

public class BinarySearchThroughIteration {
    public boolean search(int [] elements, int key) {

        if(elements == null || elements.length == 0) {
            return false;
        }
        int low  = 0;
        int high = elements.length - 1;
        while (low <= high) {
//            int mid = (low + high) / 2; //this approach will fail when (low + high) sum more than int upper range. This will result in negative number
//            int mid = low + (high - low) / 2;
            int mid =  (low + high) >>> 1;

            if(elements[mid] == key) {
                return true;
            }
            if(key < elements[mid]) {
                high = mid - 1;
            }

            if(key > elements[mid]) {
                low = mid + 1;
            }
        }
        return false;
    }
}
