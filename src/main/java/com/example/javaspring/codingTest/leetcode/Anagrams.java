package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = anagrams.groupAnagrams(strings);
        System.out.println("lists = " + lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> cpyString = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String string = String.valueOf(charArray);

            if (!map.containsKey(string)) {
                map.put(string, new ArrayList<>());
            }
            map.get(string).add(s);
        }

        System.out.println("map.values() = " + map.values());
        return new ArrayList<>(map.values());


    }
}
