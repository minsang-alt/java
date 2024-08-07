package com.example.javaspring.thread;

public abstract class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            AbstractLogger.log("인터럽트 발생 " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
