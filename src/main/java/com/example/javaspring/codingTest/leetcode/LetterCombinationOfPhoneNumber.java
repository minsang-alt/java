package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    Map<Character, String> numbers = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    // digits = "23"
    // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();

        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String digits, int i, List<String> result, StringBuilder builder) {
        if (digits.length() == i) {
            result.add(builder.toString());
            return;
        }

        Character c = digits.charAt(i);
        String s = numbers.get(c);
        for (int j = 0; j < s.length(); j++) {
            //String copyCom = "";
            //copyCom += s.charAt(j);
            //String copyCom = com + s.charAt(j);
            builder.append(s.charAt(j));
            dfs(digits, i + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);

        }

    }
}
