package com.example.javaspring.thread;

public class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        th1.start();

        //여기다 작성하면 main스레드가 현재 delay함수를 호출한것이므로 main스레드가 sleep하는 것이다. 따라서 여기다도 적지말고 Thread.으로 적자
        // th1.delay(1000);
    }
}

class ThreadEx12_1 extends Thread{
    public void run(){
        for(int i=0; i<300; i++) {
            delay(2000);
            System.out.print(i);
        }

    }

    void delay(long millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
        }
    }
}
