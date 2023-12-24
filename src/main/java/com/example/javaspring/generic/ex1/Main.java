package com.example.javaspring.generic.ex1;

import java.util.ArrayList;
import java.util.List;

class Calculator<T extends Number> {
    void add(T a, T b) {
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator<Number> car1 = new Calculator<>();
        Calculator<Integer> car2 = new Calculator<>();
        Calculator<Double> car3 = new Calculator<>();

        //  Calculator<Object> cal4 = new Calculator<Object>();
    }
}

interface Readable {
}

interface Closeable {
}

class BoxType implements Readable, Closeable {
}

class Box<T extends Readable & Closeable> {
    List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }
}