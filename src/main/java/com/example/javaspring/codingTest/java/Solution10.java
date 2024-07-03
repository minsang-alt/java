package com.example.javaspring.codingTest.java;

import java.util.Arrays;

public class Solution10 {

    private static class Block {
        int i, j;

        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] Board;


    private static Block findEmptyPosition() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Board[i][j] == 0) {
                    return new Block(i, j);
                }
            }
        }

        return null;
    }

    private static boolean isValid(int num, int row, int col) {
        return !(inRow(row, num) || inCol(col, num) || inBox(num, row, col));
    }

    private static boolean inRow(int row, int num) {
        return Arrays.stream(Board[row]).anyMatch(n -> n == num);
    }

    private static boolean inCol(int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (Board[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean inBox(int num, int row, int col) {
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (Board[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean findSolution() {
        Block emptyPos = findEmptyPosition();

        if (emptyPos == null) {
            return true;
        }

        int row = emptyPos.i;
        int col = emptyPos.j;

        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col)) {
                Board[row][col] = num;
                if (findSolution()) {
                    return true;
                }
                Board[row][col] = 0;
            }
        }

        return false;
    }

    private static int[][] solution(int[][] board) {
        Board = board;
        findSolution();
        return board;
    }


}
