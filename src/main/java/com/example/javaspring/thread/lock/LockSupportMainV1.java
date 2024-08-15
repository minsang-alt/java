package com.example.javaspring.thread.lock;

import static com.example.javaspring.thread.AbstractLogger.log;

import com.example.javaspring.thread.ThreadUtils;
import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        ThreadUtils.sleep(100);
        log("Thread-1 state: " + thread1.getState());

        log("main -> unpark(Thread-1)");
        //LockSupport.unpark(thread1);
        thread1.interrupt();

    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
