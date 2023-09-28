package com.example.javaspring.annotationEx;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Getter
public class Member   {
    private String name;
    private String phone_number;

    private String number;

    public final String hi = "HI";

    public Member(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

}
