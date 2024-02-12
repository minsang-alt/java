package com.example.javaspring.codingTest.leetcode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLetters {
    public Set<Character> toSortedSet(String s) {
        // 문자열을 문자 단위 집합으로 저장할 변수 선언
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }

            }
        });
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public String removeDuplicateLetters(String s) {
        // dbacdcbc
        // 정렬된 문자열 집합 순회
        // 1. abcd
        for (char c : toSortedSet(s)) {
            //해당 문자가 포함된 위치부터 접미사로 지정
            //acdcbc
            String suffix = s.substring(s.indexOf(c));
            // 전체 집합과 접미사 집합이 일치하면 정답에 추가하고 재귀호출 진행
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(c, '\0'));
            }
        }

        return "";
    }

}
