package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursiveDFS {

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

    public List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        //현재 노드 저장(전위 순회)
        discovered.add(v);
        //주변 노드 반복
        for (Integer w : graph.get(v)) {
            //아직 처리되지 않은 노드라면 깊이 기반 탐색 진행
            if (!discovered.contains(w)) {
                discovered = recursiveDFS(w, discovered);
            }
        }
        return discovered;
    }
}
