package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IterativeDfs {

    static Map<Integer, List<Integer>> graph = new HashMap<>();


    public static void main(String[] args) {
        initGraph();
    }

    private static void initGraph() {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));

    }

    public List<Integer> iterativeDFS(int v) {
        // 결과 노드를 저장할 리스트 선언
        List<Integer> discovered = new ArrayList<>();

        //스택 선언은 효율적인 ArrayDeque 자료형 사용
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        //스택이 모두 비워질 때까지 반복
        while (!stack.isEmpty()) {
            // 스택에서 추출
            v = stack.pop();
            // 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 스택에 삽입
            if (!discovered.contains(v)) {
                discovered.add(v);
                // 현재 노드에서 연결된 모든 주변 노드를 스택에 삽입
                for (int w : graph.get(v)) {
                    stack.push(w);
                }
            }
        }
        return discovered;
    }
}
