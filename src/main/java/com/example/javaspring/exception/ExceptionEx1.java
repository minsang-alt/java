package com.example.javaspring.exception;

public class ExceptionEx1 {
    public static void main(String[] args) {
        //처리되지않은 예외 => 컴파일 에러 발생 , 즉 예외처리가 되어야 할 부분에 예외처리가 되어 있지 않음
        //throw new Exception("고의로 발생시켰음.");

        try {
            throw new Exception("고의로 발생시킴");
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }

    }
}
