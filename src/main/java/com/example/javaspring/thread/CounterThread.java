package com.example.javaspring.thread;

public class CounterThread extends Thread {

    public CounterThread(String name) {
        super(name);
    }

    public static void main(String[] args) {
        CounterThread thread = new CounterThread("Thread-A");
        thread.start();

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                AbstractLogger.log("B");
            }
        }, "Thread-B");
        thread1.start();
    }

    @Override
    public void run() {
        while (true) {
            ThreadUtils.sleep(1000);
            AbstractLogger.log("A");
        }
    }
}
