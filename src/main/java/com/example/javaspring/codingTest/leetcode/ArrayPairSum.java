package com.example.javaspring.codingTest.leetcode;

import java.util.Arrays;

public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum arrayPairSum = new ArrayPairSum();
        int i = arrayPairSum.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}); // 1,2,2,5,6,6
        System.out.println("i = " + i);

    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            int m = Math.min(nums[i], nums[i + 1]);
            sum += m;
        }
        return sum;
    }
}
