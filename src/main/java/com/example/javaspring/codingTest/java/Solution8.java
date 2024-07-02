package com.example.javaspring.codingTest.java;

import java.util.ArrayList;

public class Solution8 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    private static int N, answer;

    public static int solution(int n, int[][] wires) {

        N = n;
        answer = Integer.MAX_VALUE;

        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : wires) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        visited = new boolean[n + 1];
        dfs(1);

        return answer;
    }


    private static int dfs(int now) {
        visited[now] = true;
        int sum = 0;

        for (int next : adjList[now]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                int a = N - cnt;
                answer = Math.min(answer, Math.abs(a - cnt));

                sum += cnt;
            }

        }

        return sum + 1;
    }
}
