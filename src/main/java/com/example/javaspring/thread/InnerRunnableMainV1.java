package com.example.javaspring.thread;

import static com.example.javaspring.thread.AbstractLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main start");
        Runnable runnable = () -> log("hello");

        Thread thread = new Thread(runnable);
        thread.start();

        log("main end");
    }
}
