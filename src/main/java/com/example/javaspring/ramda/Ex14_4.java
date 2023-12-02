package com.example.javaspring.ramda;

import java.util.function.Predicate;

public class Ex14_4 {
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcdef";
        boolean b = checkString(s, str -> str.length() > 5);
        System.out.println(b);
    }
}
