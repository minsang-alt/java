package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // candidates = [2,3,6,7], target = 7
    // Output: [[2,2,3],[7]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(candidates, target, 0, new LinkedList<>(), result, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int st, LinkedList<Integer> integers, List<List<Integer>> result,
                     int j) {
        if (target < st) {
            return;
        }
        if (target == st) {
            result.add(new ArrayList<>(integers));
        }

        for (int i = j; i < candidates.length; i++) {
            integers.add(candidates[i]);
            st += candidates[i];
            dfs(candidates, target, st, integers, result, i);
            st -= candidates[i];
            integers.removeLast();
        }

 
    }
}
