package com.example.javaspring.collectionPractice;

import java.util.HashMap;
import java.util.Map;

public class MapSearch {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "val1");
        map.put("2", "val2");
        map.put("3", "val3");

        System.out.println("1. keySet으로 순회");
        for (String key : map.keySet()) {
            System.out.println("key= " + key + ": value= " + map.get(key));
        }

        System.out.println("2. entrySet과 iterator로 순회");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + "and value = " + entry.getValue());
        }

        for (String val : map.values()) {
            System.out.println("val = " + val);
        }
    }
}
