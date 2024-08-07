package com.example.javaspring.codingTest.java;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {

    private static int max;
    private static int[] apeach;
    private static int[] answer;

    public static int[] solution(int n, int[] info) {
        List<Integer> arr = new ArrayList<>();
        //arr.contains()
        new ArrayList<>(arr);

        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);

        return max == 0 ? new int[]{-1} : answer;
    }

    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }

        return score;
    }

    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            answer = ryan.clone();
        } else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != ryan[i]) {
                    answer = ryan.clone();
                }
                break;
            }
        }
    }

    private static void backtrack(int n, int idx, int[] ryan) {
        if (n == 0) {
            calculateDiff(ryan);
            return;
        }

        for (int i = idx; i <= 10; i++) {
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }


}
