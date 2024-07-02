package com.example.javaspring.codingTest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution6 {

    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private ArrayList<Node>[] adjList;
    private int[] dist;

    public long solution(int N, int[][] road, int K) {
        // 1. 인접리스트 구성
        adjList = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }

        }

        int cnt = 0;
        for (int d : dist) {
            if (d <= K) {
                cnt++;
            }
        }

        return Arrays.stream(dist).filter(d -> d <= K).count();


    }
}
