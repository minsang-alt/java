package com.example.javaspring.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    private static int count;

    public static void main(String[] args) throws InterruptedException{
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Thread th1 = new Thread(()->{
            for(int i=0; i<100_000; i++){
                count++;
                atomicInteger.incrementAndGet();
            }
        });
        
        Thread th2 = new Thread(()->{
            for(int i = 0; i<100_000; i++){
                count++;
                atomicInteger.incrementAndGet();
            }
        });
        
        th1.start();
        th2.start();
        
        th1.join();
        th2.join();

        System.out.println("atomicInteger.get() = " + atomicInteger.get());
        System.out.println("count = " + count);

        
    }
}
