package com.example.javaspring.thread.executor;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumNumberTask extends RecursiveTask<Integer> {

    private final List<Integer> numbers;

    public SumNumberTask(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    protected Integer compute() {
        return null;
    }
}
