package com.example.javaspring.codingTest.leetcode;

public class Sort1 {
    public static void main(String[] args) {

    }

    public int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }

        }
        return a;
    }
}
