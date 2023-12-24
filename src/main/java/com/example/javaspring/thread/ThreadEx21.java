package com.example.javaspring.thread;

public class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        Runnable r1 = new RunnableEx21();
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
    }
}


class Account{
    private static int balance = 1000;
    public int getBalance(){
        return balance;
    }

    public static synchronized void withdraw0(int money){
        System.out.println("lock " + Thread.currentThread().getName());
        if (balance >= money) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
        System.out.println("unlock " + Thread.currentThread().getName());
    }


    public static void withdraw(int money){

        synchronized (RunnableEx21.class) {
            System.out.println("lock " + Thread.currentThread().getName());
            if (balance >= money) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance -= money;
            }
            System.out.println("unlock " + Thread.currentThread().getName());
        }
    }
}

class RunnableEx21 implements Runnable{
    Account acc = new Account();

    @Override
    public void run() {
        while (acc.getBalance() > 0){
            int money = (int)(Math.random()*3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }

}