package com.example.javaspring.codingTest.leetcode;

public class Trap {

    public static void main(String[] args) {
        Trap trap = new Trap();
        trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int waterValue = 0;

        int maxL = height[left];
        int maxR = height[right];

        while (left < right) {
            maxL = Math.max(height[left], maxL);
            maxR = Math.max(height[right], maxR);
            if (maxL <= maxR) {
                waterValue += maxL - height[left];
                left += 1;
            } else {
                waterValue += maxR - height[right];
                right -= 1;
            }
        }

        return waterValue;

    }
}
