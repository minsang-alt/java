package com.example.javaspring.generic;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Banana extends Fruit {
}

class Cola {
}

class FruitBox<T> {
    List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }
}

public class Main {
    public static void main(String[] args) {
        FruitBox<Fruit> box = new FruitBox<>();

        //제네릭 타입은 다형성 원리가 그대로 적용된다.
        box.add(new Fruit());
        box.add(new Apple());
        box.add(new Banana());
    }
}


