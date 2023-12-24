package com.example.javaspring.codingTest.leetcode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] ints = twoSum.twoSum(new int[]{3, 3}, 6);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            if (nums[left] + nums[right] < target) {
                left += 1;
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }
}
