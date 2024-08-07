package com.example.javaspring.thread;

public class JoinMainV1 {
    public static void main(String[] args) {
        AbstractLogger.log("start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        AbstractLogger.log("end");
    }


    static class SumTask implements Runnable {

        int startVal;
        int endVal;
        int result = 0;

        public SumTask(int startVal, int endVal) {
            this.startVal = startVal;
            this.endVal = endVal;
        }

        @Override
        public void run() {
            AbstractLogger.log("작업시작");
            ThreadUtils.sleep(2000);
            int sum = 0;
            for (int i = startVal; i <= endVal; i++) {
                sum += i;

            }
            result = sum;
            AbstractLogger.log("작업완료 + " + result);

        }
    }
}
