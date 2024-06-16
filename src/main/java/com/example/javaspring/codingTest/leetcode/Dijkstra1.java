package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dijkstra1 {

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드와 간선의 개수
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        List<List<Node>> graph = new ArrayList<List<Node>>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Node(b, cost));
        }
        // v = 6, dist[1]=% , dist[2]=%, dist[3]=%, dist[4]=%, dist[5]=%,dist[6]=%
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        for (int i = 0; i < v; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                //방문하지 않은 노드들 중에서 비용이 가장 최소인 노드를 찾는다.
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }

        }

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
        sc.close();

    }
}
