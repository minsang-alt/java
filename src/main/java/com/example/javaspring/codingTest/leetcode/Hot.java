package com.example.javaspring.codingTest.leetcode;

import java.util.PriorityQueue;

public class Hot {
    public int solution(int[] sc, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < sc.length; i++) {
            pq.add(sc[i]);
        }

        while (!pq.isEmpty() || pq.size() >= 2) {
            if (pq.peek() >= k) {
                return answer;
            }
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            answer++;
        }

        return -1;
    }
}
