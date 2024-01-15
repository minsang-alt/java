package com.example.javaspring.codingTest.leetcode;

public class Stock {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int i = stock.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("i = " + i);
    }

    public int maxProfit(int[] prices) {
        int max = 0;

        for (int j = 0; j < prices.length; j++) {
            int start = prices[j];
            for (int i = j + 1; i < prices.length; i++) {
                if (start < prices[i]) {
                    max = Math.max(max, prices[i] - start);
                }
            }
        }
        return max;
    }
}
