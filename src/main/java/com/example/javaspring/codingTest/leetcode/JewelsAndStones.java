package com.example.javaspring.codingTest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Boolean> map = new HashMap<>();

        int result = 0;

        for (char jewel : jewels.toCharArray()) {
            map.put(jewel, true);
        }

        for (char c : stones.toCharArray()) {
            if (map.getOrDefault(c, false)) {
                result++;
            }
        }
        return result;

    }
}
