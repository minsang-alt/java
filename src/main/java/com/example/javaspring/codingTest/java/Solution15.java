package com.example.javaspring.codingTest.java;

import java.util.Arrays;

public class Solution15 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2)
            : Character.compare(o1.charAt(n), o2.charAt(n)));

        System.out.println(Arrays.toString(new int[1]));
        return strings;


    }
}
