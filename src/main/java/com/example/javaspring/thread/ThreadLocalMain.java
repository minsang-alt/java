package com.example.javaspring.thread;

public class ThreadLocalMain {

    public static final ThreadLocal<UserSession> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(new UserSession(10, "main"));

        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread.sleep(6000);
        UserSession userSession = threadLocal.get();
        System.out.println("userSession = " + userSession);


    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            threadLocal.set(new UserSession(20, "MyRunnable"));

            try {
                Thread.sleep(1000);
                UserSession userSession = threadLocal.get();
                System.out.println("userSession = " + userSession);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    static class UserSession {
        private int age;
        private String name;

        public UserSession(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "UserSession{" +
                "age=" + age +
                "name=" + name +
                '}';
        }
    }
}
