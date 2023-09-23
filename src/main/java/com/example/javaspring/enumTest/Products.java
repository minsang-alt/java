package com.example.javaspring.enumTest;

import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

@Getter
public enum Products{
    SAMSUNG("삼성갤럭시북",price-> (long)(price*0.5)),
    GRAM("LG그램",price->price),
    MAC("맥북M2에어",price->price);

    private final String name;
    private final Function<Long,Long> expression;
    Products(String name, Function<Long,Long> expression){
        this.name = name;
        this.expression = expression;
    }

    public Long calculate(Long price){ return expression.apply(price); }


    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                '}';
    }
}
