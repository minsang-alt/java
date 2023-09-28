package com.example.javaspring.annotationEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Profile{
    private final String name;
    private final int age;


    private Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void print(){
        System.out.println("name = " + name);
    }
}

public class MyProfile {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Class<Profile> profileClass = Profile.class;

        final Constructor<Profile> constructor = profileClass.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);

        final Profile profile = constructor.newInstance("evo",12);

        final Method declaredMethod = profileClass.getDeclaredMethod("print");
        declaredMethod.setAccessible(true);

        declaredMethod.invoke(profile);
    }

}
