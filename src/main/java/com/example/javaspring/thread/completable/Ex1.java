package com.example.javaspring.thread.completable;

import java.util.concurrent.ExecutionException;

public class Ex1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(
//            () -> {
//                System.out.println("해당 Runnable을 실행하는 스레드 이름= " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("요것이 먼저 출력");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        future.get();
//        //Thread.sleep(1000);
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

//--------------------------------------------------------------------------------------
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
//            "thread name: " + Thread.currentThread().getName());
//
//        System.out.println(future.get());
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

//--------------------------------------------------------------------------------------
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//                System.out.println("executorService = " + executorService);
//                return Thread.currentThread().getName();
//            },
//            executorService);
//        System.out.println(future.get());
//        System.out.println(Thread.currentThread().getName());
//
//        executorService.shutdown();

//--------------------------------------------------------------------------------------
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("sleep 시작");
//            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Thread = " + Thread.currentThread().getName();
//        }).thenApply(String::toUpperCase);
//        System.out.println("MAIN Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        System.out.println("future.get() = " + future.get());

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            return "Hello";
//        }).thenAccept(s -> {
//            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()); // main
//            System.out.println("s = " + s); // s = Hello
//        }); //
//
//        System.out.println("과연 뭔가 출력될까? " + future.get()); // null
//        System.out.println("없다면 CompletableFuture의 상태는 뭘까? " + future.state()); // SUCCESS

        //--------------------------------------------------------------------------------------
//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
//            .thenRun(() -> {
//                try {
//                    System.out.println("이거 main스레드에서 실행하는데?" + Thread.currentThread().getName());
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//
//        System.out.println(" 과연 결과를 main 스레드에서 가져올까? = " + future.get());

    }

}
