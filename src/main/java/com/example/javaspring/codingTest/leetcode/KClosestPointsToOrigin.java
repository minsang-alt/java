package com.example.javaspring.codingTest.leetcode;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        

        double getDistance(int x1, int y1) {
            int yd = (int) Math.pow((y1 - y), 2);
            int xd = (int) Math.pow((x1 - x), 2);

            return Math.sqrt(yd + xd);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.getDistance(0, 0) == o2.getDistance(0, 0)) {
                return 0;
            } else if (o1.getDistance(0, 0) > o2.getDistance(0, 0)) {
                return 1;
            } else {
                return -1;
            }
        }));
        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i] = new int[]{p.x, p.y};
        }

        return result;
    }
}
