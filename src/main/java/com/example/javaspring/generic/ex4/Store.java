package com.example.javaspring.generic.ex4;

import com.example.javaspring.generic.ex3.Apple;
import com.example.javaspring.generic.ex3.GenericRepository;
import java.util.List;

public class Store {
    public static void main(String[] args) {

        GenericRepository<Apple, Integer> appleRepository = new GenericRepository<>();
        appleRepository.save(Apple.of(1));
        appleRepository.save(Apple.of(2));

        List<Apple> all = appleRepository.findAll();
        all.forEach(System.out::println);
    }
}
