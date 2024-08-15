package com.example.javaspring.thread.executor;

import static com.example.javaspring.thread.AbstractLogger.log;

import com.example.javaspring.thread.ThreadUtils;

public class RunnableTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        ThreadUtils.sleep(sleepMs);
        log(name + " 완료");

    }
}
