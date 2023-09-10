package com.example.javaspring.studyInterface.section3;

public interface B {
    default void m1(){
        System.out.println("B");
    }
}
