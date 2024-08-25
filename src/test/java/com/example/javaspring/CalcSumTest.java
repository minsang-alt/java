package com.example.javaspring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.javaspring.chap02.Calculator;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcSumTest {

    Calculator calculator;
    String numFilePath;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("numbers.txt").getPath();
    }

    @Test
    void sumOfNumbers() throws IOException {
        assertEquals(calculator.calcSum(this.numFilePath), 10);
    }

}
