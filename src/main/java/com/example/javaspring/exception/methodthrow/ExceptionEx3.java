package com.example.javaspring.exception.methodthrow;

public class ExceptionEx3 {
    //메서드에 예외 선언하기
    void method(){
        try {
            throw new InterruptedException();
        } catch (InterruptedException e) {

        }
    }

    void method1() throws InterruptedException{
        System.out.println("여긴 오겠지 ExceptionEx3");

        throw new InterruptedException();
    }
}
