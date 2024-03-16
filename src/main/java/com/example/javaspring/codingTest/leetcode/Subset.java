package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.List;

//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
public class Subset {
    public static void main(String[] args) {
        Subset subset = new Subset();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subset.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

}
