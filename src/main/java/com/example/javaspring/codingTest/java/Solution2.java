package com.example.javaspring.codingTest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {

    public static class Node {
        int dest, cost;

        public Node(int dist, int cost) {
            this.dest = dist;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접리스트 생성
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.dest]) {
                continue;
            }
            visited[now.dest] = true;

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > next.cost + now.cost) {
                    dist[next.dest] = next.cost + now.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }

        }

        return dist;

    }

}
