package com.example.javaspring.studyInterface.section2;

public interface Foo {
    void printName();
    default void newPrintName(){
        System.out.println("newPrintName");
    }
}
