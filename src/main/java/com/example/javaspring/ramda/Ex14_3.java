package com.example.javaspring.ramda;

import java.util.function.Consumer;

public class Ex14_3 {
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"홍길동,여", "benjamin,남", "corando,남"};

        printInfo(arr, (message) -> {
            String name = message.split(",")[0];
            System.out.print("이름: " + name + ",");
        }, (message) -> {
            String gender = message.split(",")[1];
            System.out.println("성별: " + gender);
        });

    }
}
