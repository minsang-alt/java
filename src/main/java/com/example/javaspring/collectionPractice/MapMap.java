package com.example.javaspring.collectionPractice;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(3, 6);

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            System.out.println(i + ", " + map.get(i));
        }

        Collection<Integer> colValues = map.values();
        for (Integer i : colValues) {
            System.out.println(i);
        }

    }
}
