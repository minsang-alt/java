package com.example.javaspring.thread.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Ex3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        CompletableFuture<Integer> resultFuture = future1.thenCombine(future2, (o1, o2) -> {
            System.out.println(Thread.currentThread().getName());
            return o1 + o2;
        });

        System.out.println("resultFuture.get() = " + resultFuture.get());


    }

}
