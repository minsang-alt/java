package com.example.javaspring.codingTest.java;

import java.util.ArrayList;

public class Solution9 {

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    private static ArrayList<ArrayList<Integer>> solution(int N) {

        result = new ArrayList<>();
        n = N;

        backtracking(0, new ArrayList<>(), 1);

        return result;
    }

    private static void backtracking(int sum, ArrayList<Integer> list, int start) {

        if (sum == 10) {
            result.add(list);
        }

        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> l = new ArrayList<>(list);
                l.add(i);
                backtracking(sum + i, l, i + 1);
            }

        }


    }

}
