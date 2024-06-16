package com.example.javaspring.codingTest.leetcode;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra2 {
    public static void main(String[] args) {

        Dijkstra2 dijkstra2 = new Dijkstra2();
        int i = dijkstra2.networkDelayTime(
            new int[][]{{1, 3, 5}, {1, 2, 10}, {2, 3, 2}, {3, 1, 1}, {3, 2, 13}, {4, 1, 8}, {4, 5, 3}, {5, 4, 9},
                {5, 2, 31}}, 5, 4);
        System.out.println(i);
    }


    // times = [[2,1,1],[2,3,1],[3,4,1]]
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();

            int u = cur.getKey();
            int dist_u = cur.getValue();

            if (!dist.containsKey(u)) {
                dist.put(u, dist_u);
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        int alt = dist_u + v.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));

                    }
                }
            }


        }
        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        return -1;

    }
}
