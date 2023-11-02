package com.example.javaspring.generic.ex3;

import java.util.List;

public class Store {
    public static void main(String[] args) {
        AppleRepository appleRepository = new AppleRepository();
        appleRepository.save(Apple.of(1));
        appleRepository.save(Apple.of(2));

        List<Apple> all = appleRepository.findAll();
        all.forEach(System.out::println);
    }
}
