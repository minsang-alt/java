package com.example.javaspring.ramda;

import java.util.function.Predicate;

public class Ex14_5 {
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.negate().test(s);
    }

    public static void main(String[] args) {
        String s = "bcdeff";

        boolean b = checkString(s, str -> str.length() > 5);
        System.out.println(b); // false 출력

    }
}
