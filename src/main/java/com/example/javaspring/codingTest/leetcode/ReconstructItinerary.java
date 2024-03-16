package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class ReconstructItinerary {
    //Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    //Output: ["JFK","MUC","LHR","SFO","SJC"]
    //Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    //Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> pathMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            pathMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            pathMap.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(result, "JFK", pathMap);

        return result;
    }

    private void dfs(List<String> result, String path, Map<String, PriorityQueue<String>> pathMap) {

        //from -> to 값이 존재하는 경우 반복해서 재귀 DFS
        while (pathMap.containsKey(path) && !pathMap.get(path).isEmpty()) {
            dfs(result, pathMap.get(path).poll(), pathMap);
        }
        result.add(0, path);

    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());

            }
            results.add(0, stack.pop());
        }
        return results;
    }



}
