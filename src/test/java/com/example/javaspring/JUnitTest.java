package com.example.javaspring;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class JUnitTest {
    static JUnitTest jUnitTest;

    @Test
    public void test() {
        assertNotEquals(this, jUnitTest);
        jUnitTest = this;
    }

    @Test
    public void test2() {
        assertNotEquals(this, jUnitTest);
        jUnitTest = this;
    }


}
