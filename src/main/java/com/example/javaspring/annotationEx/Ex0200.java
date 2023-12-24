package com.example.javaspring.annotationEx;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Ex0200 {
    String name();
    int age() default 13;
}


