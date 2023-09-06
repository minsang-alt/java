package com.example.javaspring.studyInterface.section2;

public class ImplFoo implements Foo{

    @Override
    public void printName() {
        System.out.println("this is ImplFoo");
    }

    @Override
    public String getName() {
        return null;
    }


    public static void main(String[] args) {
        ImplFoo implFoo = new ImplFoo();
        implFoo.printName();
        implFoo.newPrintName();

        //쓰면 안됨
        //implFoo.dontWriteThisMethod();
    }
}
