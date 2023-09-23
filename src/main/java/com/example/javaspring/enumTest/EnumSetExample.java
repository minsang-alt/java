package com.example.javaspring.enumTest;

import java.util.EnumSet;

enum Fruit{APPLE,BANANA,ORANGE}
public class EnumSetExample {


    public static void main(String[] args) {
        EnumSet<Fruit> set1, set2, set3, set4;

        //Adding elements
        set1 = EnumSet.of(Fruit.BANANA,Fruit.ORANGE);

        set2 = EnumSet.complementOf(set1);

        set3 = EnumSet.allOf(Fruit.class);

        set4 = EnumSet.range(Fruit.APPLE, Fruit.ORANGE);

        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("set3 = " + set3);
        System.out.println("set4 = " + set4);
    }

}
