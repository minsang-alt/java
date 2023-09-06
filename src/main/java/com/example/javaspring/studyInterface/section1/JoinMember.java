package com.example.javaspring.studyInterface.section1;

public interface JoinMember {
    default void preJoin(){
        System.out.println("Join Member");
    }
}
