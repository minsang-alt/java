package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int day = 0; day < temperatures.length; day++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) {
                int preDay = stack.pop();
                result[preDay] = day - preDay;
            }
            stack.push(day);

        }

        return result;
    }
}
