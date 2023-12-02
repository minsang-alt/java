package com.example.javaspring.ramda;

import java.util.function.Function;

public class Ex14_7 {
    private String answer = "hello";

    public void run() {
        answer = "test";
        Function<String, String> fun1 = text -> text + ": " + answer;
        System.out.println(fun1.apply("answer is"));
        answer = "not Hello";
    }

    public static void main(String[] args) {
        Ex14_7 ex14_7 = new Ex14_7();
        ex14_7.run();
    }
}
