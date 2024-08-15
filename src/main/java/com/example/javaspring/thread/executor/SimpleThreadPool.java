package com.example.javaspring.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(n -> es.execute(() -> {

        }));
    }
}
