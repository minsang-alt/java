package com.example.javaspring.codingTest.java;

public class Solution16 {

    /**
     * @param arr [ [1,2,3,4], [5,6,7,8], [9,10,11,12], [13,14,15,16] ]
     * @param n   1
     * @return [ [13,9,5,1], [14,10,6,2], [15,11,7,3], [16,12,8,4] ] - arr[0][0] -> arr[0][3] - arr[0][1] -> arr[1][3] -
     * arr[0][2] -> arr[2][3] - arr[0][3] -> arr[3][3] - arr[1][0] -> arr[0][2] - arr[i][j] -> arr[j][(N-1)-i]
     */
    private static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - 1 - i] = arr[i][j];
            }
        }

        return rotatedArr;
    }
}
