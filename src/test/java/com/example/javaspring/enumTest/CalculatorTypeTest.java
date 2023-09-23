package com.example.javaspring.enumTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTypeTest {
    @Test
    public void 코드에_따라_서로다른_계산() throws Exception{
        CalculatorType code = CalculatorType.CALC_A;
        long originValue = 10000L;
        long result = code.calculate(originValue);

        assertEquals(10000L,result);
    }

}