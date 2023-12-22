package com.example.javaspring.codingTest.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        MostCommonWord commonWord = new MostCommonWord();

        String result = commonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"});

        System.out.println(result);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String w : words) {
            if (!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }
        //return counts.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
