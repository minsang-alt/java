package com.example.javaspring.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhatExecutor {

    private static final int MAX_THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(2);

//        IntStream.range(0, MAX_THREAD_COUNT).forEach(i -> es.submit(new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                System.out.println("i = " + (i + 1) + " name: " + Thread.currentThread().getName());
//                Thread.sleep(300);
//                return null;
//            }
//        }));

//        List<Callable<Long>> tasks = List.of(new MyCallable(), new MyCallable(), new MyCallable(), new MyCallable());
//        List<Future<Long>> futures = es.invokeAll(tasks);
//        Thread.sleep(300);
//        for (Future<Long> future : futures) {
//            System.out.println("future.get() = " + future.get());
//            System.out.println("future.state() = " + future.state());
//        }

        Future<Long> submit = es.submit(new MyCallable());
        try {
            System.out.println("submit.get() = " + submit.get());
        } catch (ExecutionException e) {
            System.out.println("e.getMessage() = 작업중단 " + e.getMessage());
        } finally {
            if (!es.isTerminated()) {
                es.close();
            }
        }

        es.shutdown();
    }

    public static class MyCallable implements Callable<Long> {

        private boolean flag = true;

        @Override
        public Long call() throws Exception {
            System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());
            Thread.sleep(100);
            if (flag) {
                throw new IllegalStateException("예외처리 출력");
            }

            return Thread.currentThread().threadId();
        }
    }
}
