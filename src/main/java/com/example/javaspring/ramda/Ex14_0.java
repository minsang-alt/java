package com.example.javaspring.ramda;

public class Ex14_0 {
    public static void main(String[] args) {
        MyFunction f1 = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        // 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        MyFunction f2 = (a, b) -> a > b ? a : b;

        int val0 = f1.max(3, 5);
        int val = f2.max(3, 5);

        System.out.println(val0);
        System.out.println(val);
    }
}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함. 꼭 안붙여도 되는 Override와 같은 존재
interface MyFunction {
    public abstract int max(int a, int b); // int max(int a, int b). public abstract 생략 가능
}