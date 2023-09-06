package com.example.javaspring.studyInterface.section1;

public class Member implements JoinMember,JoinGroup{

    @Override
    public void preJoin() {
        JoinMember.super.preJoin();
        JoinGroup.super.preJoin();
    }

    public static void main(String[] args) {
        Member member= new Member();
        member.preJoin();

        JoinGroup.staticPreJoin();
    }


}
