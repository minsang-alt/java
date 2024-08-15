package com.example.javaspring.thread.executor;

import static com.example.javaspring.thread.AbstractLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log(
                "[pool = " + pool + ", active = " + active + ", queuedTasks = " + queued + ", completedTask= "
                    + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }
}
