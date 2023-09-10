package com.example.javaspring.exception.methodthrow;

public class ExceptionEx6 {
    public static void main(String[] args) throws InterruptedException{
        ExceptionEx4 ex4 = new ExceptionEx4();
        ex4.method2();
        System.out.println("넘어가나?"); //안온다
    }
}
