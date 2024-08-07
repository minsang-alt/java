package com.example.javaspring.codingTest.java;

public class Solution19 {

    private static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int val = 1;

        int startCol = 0;
        int endCol = n - 1;
        int startRow = 0;
        int endRow = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                answer[startRow][i] = val++;
            }

            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                answer[i][endCol] = val++;
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    answer[endRow][i] = val++;
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    answer[i][startCol] = val++;
                }
                startRow++;
            }

            
        }
        return answer;


    }
}
