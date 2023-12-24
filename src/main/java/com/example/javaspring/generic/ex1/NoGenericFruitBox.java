package com.example.javaspring.generic.ex1;

class Apple {
}

class Banana {
}

class FruitBox<T> {
    private T[] fruit;

    public FruitBox(T[] fruit) {
        this.fruit = fruit;
    }

    public T getFruit(int index) {
        return fruit[index];
    }
}


public class NoGenericFruitBox {

    public static void main(String[] args) {
        Apple[] appleArr = {
                new Apple(),
                new Apple()
        };
        FruitBox<Apple> box = new FruitBox<>(appleArr);

        Apple apple = (Apple) box.getFruit(0);
        //  Banana banana = (Banana) box.getFruit(1);

        //Sample<Integer>[] arr0 = new Sample<>[10];
        Sample<Integer>[] arr1 = new Sample[10];

        arr1[0] = new Sample<Integer>();
        arr1[1] = new Sample<>();
        //arr1[2] = new Sample<String>();

    }


}


interface Isample<T> {
    public void addElement(T t, int index);

    public T getElement(int index);
}

class Sample<T> implements Isample<T> {
    private T name;
    private T age;

    @Override
    public void addElement(T o, int index) {

    }

    @Override
    public T getElement(int index) {
        return null;
    }
}
