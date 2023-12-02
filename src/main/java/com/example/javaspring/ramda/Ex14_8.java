package com.example.javaspring.ramda;

import static java.awt.Color.GREEN;

import java.util.function.BiFunction;

public class Ex14_8 {

    private static class Apple {
        private int num;

        Apple() {
        }

        Apple(int num) {
            this.num = num;
        }

        Apple(String color, int num) {

        }
    }

    public static void main(String[] args) {

        BiFunction<String, Integer, Apple> c3 = Apple::new; // Apple(String color, Integer weight)의 생성자 참조
        Apple a3 = c3.apply(String.valueOf(GREEN),
                110); // BiFunction의 apply 메서드에 색과 무게를 인수로 제공해서 새로운 Apple 객체를 만들 수 있다.

        //BiFunction<String, Integer, Apple> c3 = (color, weight) -> new Apple(color, weight);
    }
}
