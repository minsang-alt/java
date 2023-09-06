package com.example.javaspring.studyInterface.section1;

public interface JoinGroup {
    default void preJoin(){
        System.out.println("JoinGroup");
    }

    static void staticPreJoin(){
        System.out.println("static Join Group");
    }
}
