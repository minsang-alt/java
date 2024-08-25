package com.example.javaspring.thread.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "hello2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("f3 = " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
                // throw new IllegalStateException("sorry");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello3";
        });

        CompletableFuture<String> future = CompletableFuture.allOf(f1, f2, f3)
            .thenApply(x -> {
                System.out.println("Thread: " + Thread.currentThread().getName());
                return Stream.of(f1, f2, f3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(","));
            })
            .exceptionally(e -> "예외 발생");

        System.out.println("화이팅");

        System.out.println("결과 = " + future.get());
    }
}
