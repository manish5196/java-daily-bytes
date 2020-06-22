package com.example.algorithms;

/**
 * Binary Search
 */
public class BinarySearchThroughRecursion {

    public boolean search(int [] elements, int key) {
        if(elements == null || elements.length == 0) {
            return false;
        }
        // calculate the initial low and high, means list start index and last index
        return search(elements, key, 0, elements.length - 1);
    }

    private boolean search(int [] elements, int key, int low, int high) {
        if(low <= high) {
            //Calculate the mid (guess)
//            int mid = (low + high) / 2; //this approach will fail when (low + high) sum more than int upper range. This will result in negative number
//            int mid = low + (high - low) / 2;
            int mid =  (low + high) >>> 1;

            //check if mid(guess) is the search key which we are looking in list
            if (elements[mid] == key) {
                return true;
            }

            //check key less than mid(guess), means search key must left of the mid(guess)
            // so adjust the high (mid - 1)
            if (key < elements[mid]) {
                return search(elements, key, low, mid -1);
            }
            //search key greater than mid(guess), means search key must right of the mid(guess)
            // so adjust the low (mid + 1)
            return search(elements, key, mid + 1, high);
        }

        // If nothing matches then by default key not present
        return false;
    }

}
