package com.example.javaspring.codingTest.java;


import java.util.ArrayDeque;

public class Solution5 {
    // ["SOOOL"]
    // ["XXXXO"]
    // ["OOOOO"]
    // ["OXXXX"]
    // ["OOOOE"]

    private char[][] map;
    private int[][] dist;

    private int N, M;

    private int[] nx = {0, 1, 0, -1};
    private int[] ny = {-1, 0, 1, 0};


    private class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int bfs(Point start, Point end) {
        dist = new int[N][M];
        dist[start.y][start.x] = 1;

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(start);

        while (!queue.isEmpty()) {
            Point now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + nx[i];
                int nextY = now.y + ny[i];

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                    continue;
                }

                if (dist[nextY][nextX] > 0) {
                    continue;
                }

                if (dist[nextY][nextX] == 'X') {
                    continue;
                }

                dist[nextY][nextX] = dist[now.y][now.x] + 1;
                queue.add(new Point(nextX, nextY));
                
                if (map[nextY][nextX] == map[end.y][end.x]) {
                    return dist[nextY][nextX] - 1;
                }

            }

        }

        return -1;
    }


    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        Point start = null, end = null, lever = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    start = new Point(j, i);
                } else if (map[i][j] == 'E') {
                    end = new Point(j, i);
                } else if (map[i][j] == 'L') {
                    lever = new Point(j, i);
                }
            }
        }

        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);

        return startLever == -1 || leverEnd == -1 ? -1 : startLever + leverEnd;


    }

}
