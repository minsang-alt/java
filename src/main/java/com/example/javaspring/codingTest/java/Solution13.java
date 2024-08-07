package com.example.javaspring.codingTest.java;

public class Solution13 {
    public static void main(String[] args) {
        String s = "hello";

        char[] arr = new char[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                String alpha = String.valueOf((char) ('a' + i));
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(alpha);
                }
            }
        }

        System.out.println(sb.toString());

    }
}
