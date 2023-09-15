package com.example.javaspring.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    //길이가 8글자 이상
    //0부터 9 사이의 숫자를 포함
    //대문자 포함

    //세 규칙을 모두 충족하면 암호는 강함
    //2개의 규칙을 충족하면 암호는 보통
    //1개 이하의 규칙을 충족하면 암호는 약함

    @Test
    void checkLength(){
        String password = "12345678";
        assertTrue(Password.checkLength(password),"비밀번호가 8자 이상이어야 한다.");

        assertFalse(Password.checkLength("123"));
    }

    @Test
    void checkNumber(){
        String password = "123a";
        assertTrue(Password.checkNumber(password),"비밀번호에는 0~9의 숫자가 있어야 합니다");

        assertFalse(Password.checkNumber("abc"));
    }

    @Test
    void checkUpperCase(){
        String password = "A123b";
        assertTrue(Password.checkUpperCase(password),"비밀번호에는 대문자가 포함되어야 합니다");

        assertFalse(Password.checkUpperCase("abc123d"));
    }

    @Test
    void checkStrength(){
        String password = "1234ABc5";
        assertEquals("Strength",Password.check(password));

        assertEquals("Weak",Password.check("123abc5"));
    }

    @Test
    void checkNormal(){
        String password = "abcdefgeF";
        assertEquals("Normal",Password.check(password));


    }
}
