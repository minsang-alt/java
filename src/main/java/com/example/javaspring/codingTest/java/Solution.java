package com.example.javaspring.codingTest.java;

import java.util.ArrayList;

public class Solution {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        // 1. graph에 있는 경로를 인접리스트로 변환
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
