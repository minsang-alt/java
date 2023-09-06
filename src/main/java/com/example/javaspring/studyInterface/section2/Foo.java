package com.example.javaspring.studyInterface.section2;

public interface Foo {

     String message = "테스트";

    void printName();
    default void newPrintName(){
        System.out.println("newPrintName");
    }

    default void dontWriteThisMethod(){
        System.out.println(getName().toUpperCase());
    }

    static String receiveMessage(){
        return message;
    }

    String getName();
}
