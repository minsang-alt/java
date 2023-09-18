package com.example.javaspring.thread;

public class ThreadEx2 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx2_1 th1 = new ThreadEx2_1();
        ThreadEx2_1 th2 = new ThreadEx2_1();

        th1.start();
        th2.start();
    }
}

class ThreadEx2_1 extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
