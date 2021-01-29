package com.example.problem;

import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestSubStringWithoutRepeating {

    public static void main(String[] args) {
        String input = "`aab";
        System.out.println(subStringUsingHashSet(input).length());
    }

    public static String subStringUsingHashSet(String input){

        HashSet<Character> set = new HashSet<>();

        String longestOverAll = "";
        String longestTillNow = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (set.contains(c)) {
                for(int j = 0; j < longestTillNow.length(); j++) {
                    char ch = longestTillNow.charAt(j);
                    set.remove(ch);
                    if(ch == c) {
                        break;
                    }

                }
                longestTillNow = set.stream().map(character -> ""+character).collect(Collectors.joining(""));

            } else {
                longestTillNow += c;
                set.add(c);
            }
            if (longestTillNow.length() > longestOverAll.length()) {
                longestOverAll = longestTillNow;
            }
        }
        return longestOverAll;
    }

}
