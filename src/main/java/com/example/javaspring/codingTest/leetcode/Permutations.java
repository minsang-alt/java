package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, visited, result,new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int[] visited, List<List<Integer>> result, List<Integer> list) {
        if(nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            list.add(nums[i]);
            dfs(nums, visited, result, list);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
