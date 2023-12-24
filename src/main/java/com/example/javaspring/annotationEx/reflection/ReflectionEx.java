package com.example.javaspring.annotationEx.reflection;

import com.example.javaspring.annotationEx.Ex0500;
import com.example.javaspring.annotationEx.Member;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class<Member> aClass = Member.class;


        // Member member1 = new Member();
        //   Class<? extends Member> bClass = member1.getClass();

        // Class<?> cClass = Class.forName("com.example.javaspring.annotationEx.Member");


/*
        System.out.println("=====getMethods()=====");
        Method[] methods = Member.class.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println("======================");
*/



/*        System.out.println("=====getFields()=====");
        Field[] fields = Member.class.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        System.out.println("======================");*/

        System.out.println("===getAnnotations()=====");
        Annotation[] annotations = Ex0500.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

/*        Class<Member> memberClass = Member.class;
        Member member = new Member("evo", "01012345678");

        for (Field field : memberClass.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.getName().equals("name")){
                field.set(member,"EVOO");
            }
            System.out.println("field.getType() = " + field.getType() + " / field.getName() = " + field.getName()
                    + " / field.get(member) = " + field.get(member)
            );
        }*/


    }
}
