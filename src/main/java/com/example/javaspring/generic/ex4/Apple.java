package com.example.javaspring.generic.ex4;

public class Apple implements Entity<Integer> {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public static Apple of(Integer id) {
        Apple apple = new Apple();
        apple.id = id;
        return apple;
    }
}
