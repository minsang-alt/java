package com.example.javaspring.exception.methodthrow;

public class ExceptionEx5 {
    public static void main(String[] args) {
        ExceptionEx4 ex4 = new ExceptionEx4();
        try {
            ex4.method2();
        }catch (InterruptedException e){
            System.out.println("ExceptionEx5");
        }
        System.out.println("넘어감");

    }
}
