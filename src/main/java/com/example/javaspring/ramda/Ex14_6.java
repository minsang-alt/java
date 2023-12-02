package com.example.javaspring.ramda;

import java.util.function.Function;

public class Ex14_6 {
    public static void change(String s, Function<String, Integer> fun) {
        int in = fun.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        String s = "1234";
        change(s, str -> Integer.parseInt(s));
    }
}

