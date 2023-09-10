package com.example.javaspring.exception.methodthrow;

public class ExceptionEx4 {
    void method2() throws InterruptedException{
        ExceptionEx3 ex3 = new ExceptionEx3();
        System.out.println("ExceptionEx4");
        ex3.method1();
    }
}
