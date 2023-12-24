package com.example.javaspring.enumTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Operation1 {
    PLUS("+") {public double apply(double x,double y){return x+y;}},
    MINUS("-"){public double apply(double x,double y){return x-y;}},
    TIMES("*"){public double apply(double x,double y){return x*y;}},
    DIVIDE("/"){public double apply(double x,double y){return x/y;}};


    private static final Map<String,Operation1> stringToEnum =
            Stream.of(values()).collect(
                    Collectors.toMap(Object::toString, e->e));
    private final String symbol;

    private static final Map<String, String> testMap = new HashMap<>();
    Operation1(String symbol){
        this.symbol = symbol;
        //testMap.put("test","테스트");
    }
    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
    public static Optional<Operation1> fromString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
