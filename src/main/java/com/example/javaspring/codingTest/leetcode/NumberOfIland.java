package com.example.javaspring.codingTest.leetcode;

public class NumberOfIland {

    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        char[][] discovered = new char[][]{};

        int numIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '0') {
                    numIsland++;
                    dfs(i, j, grid);
                }
            }
        }

        return numIsland;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[i].length
                    || grid[nextX][nextY] == '0') {
                continue;
            }

            dfs(nextX, nextY, grid);
        }


    }
}
