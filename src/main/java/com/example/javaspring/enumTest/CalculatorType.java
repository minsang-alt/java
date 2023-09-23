package com.example.javaspring.enumTest;

import java.util.function.Function;

public enum CalculatorType {
    CALC_A(value->value),
    CALC_B(value->value*10),
    CALC_C(value->value*3),
    CALC_ETC(value->0L);

    private Function<Long,Long> expression;
    CalculatorType(Function<Long,Long> expression){this.expression = expression;}

    public long calculate(long value){return expression.apply(value);}

}
