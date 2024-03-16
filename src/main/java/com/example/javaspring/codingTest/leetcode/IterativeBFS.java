package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class IterativeBFS {
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

        RecursiveDFS dfs = new RecursiveDFS();
        List<Integer> discovered = dfs.recursiveDFS(1, new ArrayList<>());

    }

    public List<Integer> iterativeBFS(int start_v) {
        // 결과 노드를 저장할 리스트 선언
        List<Integer> discovered = new ArrayList<>();
        // 시작 노드 삽입
        discovered.add(start_v);
        // 큐는 인터페이스이며 자료형 선언은 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드 삽입
        queue.add(start_v);
        // 큐가 모두 비워질 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 추출
            int v = queue.poll();
            // 현재 노드에서 연결된 모든 주변 노드를 큐에 삽입
            for (int w : graph.get(v)) {
                //이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 큐에 삽입
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }

        return discovered;
    }
}
