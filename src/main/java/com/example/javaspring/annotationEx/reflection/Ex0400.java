package com.example.javaspring.annotationEx.reflection;

import java.lang.annotation.Annotation;

public class Ex0400 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.example.javaspring.annotationEx.Ex0300");
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
    }
}
