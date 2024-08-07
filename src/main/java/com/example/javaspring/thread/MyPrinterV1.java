package com.example.javaspring.thread;

import static com.example.javaspring.thread.AbstractLogger.log;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MyPrinterV1 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printThread = new Thread(printer, "printer1");
        Thread printThread2 = new Thread(printer, "printer2");
        Thread printThread3 = new Thread(printer, "printer3");

        printThread.start();
        printThread2.start();
        printThread3.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요. 종료 (q): ");
            String job = scanner.nextLine();
            if (job.equals("q")) {
                printThread.interrupt();
                printThread2.interrupt();
                printThread3.interrupt();
                break;
            }

            printer.addJob(job);
        }

    }

    static class Printer implements Runnable {


        Deque<String> jobQueue = new ConcurrentLinkedDeque<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    ThreadUtils.sleep(1000);
                    continue;
                }
                try {
                    String job = jobQueue.poll();
                    log("출력시작: " + job + ", 대기문서: " + jobQueue);
                    Thread.sleep(3000);
                    log("출력완료: " + job);

                } catch (InterruptedException e) {
                    log("인터럽트");
                    break;
                }

            }

            log("프린트 종료");
        }

        public void addJob(String job) {
            jobQueue.add(job);
        }
    }
}
