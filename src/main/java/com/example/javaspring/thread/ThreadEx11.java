package com.example.javaspring.thread;

import java.util.Iterator;
import java.util.Map;

import static java.lang.Thread.sleep;

public class ThreadEx11 {
    public static void main(String[] args) throws InterruptedException {
        ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
        ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
        t1.start();
        t2.start();

        sleep(1000);
    }
}

class ThreadEx11_1 extends Thread{
    ThreadEx11_1(String name){
        super(name);
    }

    public void run(){
        try{
            sleep(5*1000);
        }catch (InterruptedException e){}
    }

}

class ThreadEx11_2 extends Thread{
    ThreadEx11_2(String name){
        super(name);
    }
    public void run(){
        Map map = getAllStackTraces();
        Iterator it = map.keySet().iterator();

        int x = 0;
        while(it.hasNext()){
            Object obj = it.next();
            Thread t = (Thread)obj;
            StackTraceElement[] ste = (StackTraceElement[]) map.get(obj);

            System.out.println("["+ ++x +"] name : " + t.getName()
                        + ", group : " + t.getThreadGroup().getName()
                        + ", daemon : " + t.isDaemon()
            );

            for (int i = 0; i < ste.length; i++) {
                System.out.println("ste[i] = " + ste[i]);
            }

            System.out.println();
        }
    }
}

