package com.example.javaspring.codingTest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        // 문자열을 문자 단위로 반복
        for (char c : s.toCharArray()) {
            // 이미 등장했던 문자이고 슬라이딩 윈도우의 왼쪽
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            used.put(c, right);
            right++;
        }
        return maxLength;

    }
}
