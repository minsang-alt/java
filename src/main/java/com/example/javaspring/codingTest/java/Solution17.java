package com.example.javaspring.codingTest.java;

public class Solution17 {

    // 1행 1열 : 1,2,3  9,6,3 => 1*9 + 2*6 + 3*3 = 30 [0][0] * [0][0]+ [0][1]*[1][0] + [0][2]*[2][0]
    // 1행 2열 : 1,2,3 8,5,2 => 1*8 + 2*5 + 3*2 = 24
    // 1행 3열
    // 2행 1열

    private static int[][] multiMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] multis = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    multis[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return multis;
    }

    private static int[][] transporateMatrix(int[][] matrix) {
        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }


    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] multis = multiMatrix(matrix1, matrix2);

        int[][] transMatrix = transporateMatrix(multis);

        return transMatrix;

    }
}
