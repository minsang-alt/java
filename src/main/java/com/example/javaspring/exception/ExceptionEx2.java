package com.example.javaspring.exception;

public class ExceptionEx2  {
    public static void main(String[] args) {
        throw new RuntimeException(); //RuntimeException을 고의로 발생시킨다.

        //비정상 프로그램 종료가 아닌 정상적 프로그램을 실행하고 싶으면 try-catch 예외처리하면 된다

    }
}
