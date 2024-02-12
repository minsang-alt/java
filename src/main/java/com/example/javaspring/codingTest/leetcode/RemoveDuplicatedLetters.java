package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatedLetters {


    // cbacdcbc
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char c : s.toCharArray()) {

            counter.put(c, counter.get(c) - 1);

            //이미 스택에 존재할시 넘어감
            if (seen.get(c) != null && seen.get(c)) {
                continue;
            }

            //스택이 비지 않고 꺼내서 비교 && 만약 꺼낸 것과 비교했을때 사전순으로 앞서있을때와 뒤에 똑같은 문자가 더 있을때 해당 스택에 있는것 제거 후 푸시
            while (!stack.isEmpty() && counter.get(stack.peek()) > 0 && stack.peek() > c) {
                seen.put(stack.pop(), false);
            }

            stack.push(c);
            seen.put(c, true);


        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();

    }

}
