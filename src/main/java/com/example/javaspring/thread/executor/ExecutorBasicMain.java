package com.example.javaspring.thread.executor;

import static com.example.javaspring.thread.AbstractLogger.log;
import static com.example.javaspring.thread.ThreadUtils.sleep;
import static com.example.javaspring.thread.executor.ExecutorUtils.printState;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorBasicMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result value = " + result);
        es.close();

        // ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("==초기 상태==");
        printState(es);
//        es.execute(new RunnableTask("taskA"));
//        es.execute(new RunnableTask("taskB"));
//        es.execute(new RunnableTask("taskC"));
//        es.execute(new RunnableTask("taskD"));

        log("== 작업 수행중 ==");
        printState(es);

        sleep(3000);
        log("작업 수행 완료 ==");
        printState(es);

        es.close();
        log("shutdown 완료 ==");
        printState(es);

    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("Callable 시작");

            sleep(2000);
            int value = new Random().nextInt(10);

            log("Callable 시작");
            return value;
        }
    }
}
