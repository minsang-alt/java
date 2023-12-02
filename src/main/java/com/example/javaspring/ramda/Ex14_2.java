package com.example.javaspring.ramda;

import java.util.function.Supplier;

public class Ex14_2 {
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {100, 0, 30, -20, 60};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxValue);
    }
}
