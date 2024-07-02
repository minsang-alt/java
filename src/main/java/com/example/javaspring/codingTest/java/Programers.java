package com.example.javaspring.codingTest.java;

import java.util.ArrayList;

public class Programers {


    private int NUM;
    private ArrayList<Integer>[] adjList;
    private int[] addProductNum;

    //private int[] dist;

    private boolean[] visited;
    private boolean check = false;

    private int[] copyLimits;
    private int K;

    private int answer = 0;

    public static void main(String[] args) {
        Programers program = new Programers();

        int k = 300;
        int[] limits = {2000, 1000, 3000, 200, 600, 500};
        int[][] sockets = {
            {2, 3, -1, -1, -1},
            {4, 0, -1, -1, 6},
            {5, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0},
            {-1, -1, -1, -1, -1},
            {-1, -1, 0, 0, 0}
        };

        int result = program.solution(k, limits, sockets);
        System.out.println("Result: " + result);
    }

    public int solution(int k, int[] limits, int[][] sockets) {
        NUM = limits.length;
        K = k;
        copyLimits = new int[NUM + 1];
        for (int i = 1; i < limits.length + 1; i++) {
            copyLimits[i] = limits[i - 1];
        }

        adjList = new ArrayList[NUM + 1];
        addProductNum = new int[NUM + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < NUM; i++) {
            int[] edge = sockets[i];
            for (int j = 0; j < 5; j++) {
                if (edge[j] > 0) {
                    adjList[i + 1].add(edge[j]);
                } else if (edge[j] == -1) {
                    addProductNum[i + 1] = addProductNum[i + 1] + 1;
                }
            }
        }

        visited = new boolean[NUM + 1];

        //누적합
        sumDfs(1);

        for (int i = 1; i <= NUM; i++) {
            dfs(1);
        }

        return answer;

    }

    private int sumDfs(int now) {
        for (int next : adjList[now]) {
            int val = sumDfs(next);
            addProductNum[now] += val;
        }
        return addProductNum[now];
    }

    private int dfs(int now) {

        for (int next : adjList[now]) {

            int val = dfs(next);

            if (val > 0) {
                addProductNum[now] -= val;
                return val;
            }

        }

        if (addProductNum[now] * K > copyLimits[now]) {
            int requiredValue = copyLimits[now] / K;
            int difference = addProductNum[now] - requiredValue;
            addProductNum[now] = addProductNum[now] - difference;
            answer += difference;
            return difference;
        }

        return 0;
    }


}
