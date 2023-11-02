package com.example.javaspring.generic.ex4;

public class Banana implements Entity<Integer> {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public static Banana of(Integer id) {
        Banana Banana = new Banana();
        Banana.id = id;
        return Banana;
    }
}
