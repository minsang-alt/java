package com.example.javaspring.generic.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
/*
        MegaBox<Integer> box = new MegaBox<>();
        box.addBoxNoStatic(1, 2);

        box.<String>addBoxNoStatic("a", "b");
        box.addBoxNoStatic(5.55, 3.13);
*/

        List<Integer> integerList = new ArrayList<>(List.of(1, 3, 6, 2));
        Collections.sort(integerList);
        System.out.println("integerList = " + integerList);

        
    }

}
/*

class MegaBox<T> {
    public T addBox(T x, T y) {
        //...
    }

    public <T> T addBoxNoStatic(T x, T y) {
        //...
    }
}

*/
