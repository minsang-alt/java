package com.example.javaspring.jvm;

import java.util.Arrays;
import java.util.List;

public class JVMInstructionTest implements Runnable {

    public JVMInstructionTest() {
        System.out.println("constructor method");
    }

    private void privateMethod() {
        System.out.println("private method");
    }

    static void staticMethod() {
        System.out.println("static method");
    }

    void p() {
        System.out.println("instance method");
    }

    public void d(String str) {
        System.out.println("for method handle " + str);
    }

    static void ddd(String str) {
        System.out.println("static method for method handle " + str);
    }

    public static void main(String[] args) {
        /**
         * invoke special
         */
        JVMInstructionTest test = new JVMInstructionTest();

        /**
         * invoke virtual
         */
        test.privateMethod();

        /**
         * invoke virtual
         */
        test.p();

        /**
         * invoke static
         */
        staticMethod();

        /**
         * invoke interface
         */
        Runnable r = new JVMInstructionTest();
        r.run();

        /**
         * invoke dynamic
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.forEach(System.out::println);
    }

    @Override
    public void run() {
        System.out.println("interface Method");
    }
}
