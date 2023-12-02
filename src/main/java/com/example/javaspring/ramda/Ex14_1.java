package com.example.javaspring.ramda;

@FunctionalInterface
interface MyFunction1 {
    void run(); // public abstract void run();
}

public class Ex14_1 {
    static void execute(MyFunction1 f) {
        f.run();
    }

    static MyFunction1 getMyFunction() {
        MyFunction1 f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction의 run()을 구현
        MyFunction1 f1 = () -> System.out.println("f1.run()");
        f1.run();
        execute(f1);
    }
}
