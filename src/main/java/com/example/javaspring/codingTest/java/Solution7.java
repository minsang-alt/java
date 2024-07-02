package com.example.javaspring.codingTest.java;

import java.util.ArrayDeque;

public class Solution7 {


    private static class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    private static int N;
    private static int[][][] visited;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {-1, 0, 1, 0};


    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N - 1 && 0 <= y && y < N - 1;
    }

    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[y][x] == 1;
    }

    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }

    private static boolean isShouldUpdate(int x, int y, int dir, int nextCost) {
        return visited[dir][y][x] == 0 || visited[dir][y][x] > nextCost;
    }

    public int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[4][N][N];

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (isBlocked(board, nextX, nextY)) {
                    continue;
                }

                int nextCost = calculateCost(i, now.dir, now.cost);

                if (nextX == N - 1 && nextY == N - 1) {
                    answer = Math.min(answer, nextCost);
                } else if (isShouldUpdate(nextX, nextY, i, nextCost)) {
                    queue.add(new Node(nextX, nextY, i, nextCost));
                    visited[i][nextY][nextX] = nextCost;
                }


            }
        }
        return answer;

    }
}
