package com.example.javaspring.generic.ex1;

import java.util.List;

interface Iadd<T> {
    public T add(T x, T y);
}

class Fruit {
}

class Cherry extends Fruit {
}

public class GenericFunctional {
    public static void main(String[] args) {
        Iadd<Integer> o = (x, y) -> x + y;
        int result = o.add(10, 20);
        System.out.println(result);

        Object[] arr = new Integer[10];

        //List<Object> list = new ArrayList<Integer>();

/*
        Cherry[] cherriesBox = new Cherry[]{
                new Cherry(),
                new Cherry()
        };

        print(cherriesBox);
*/

        //List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        //print(list);
    }

    public static void print(List<Object> box) {
        for (Object e : box) {
        }
    }
}



