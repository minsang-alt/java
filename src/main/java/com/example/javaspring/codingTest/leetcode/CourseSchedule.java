package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: true
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //순환 판별 알고리즘 구현
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            //값이 존재하지 않을 경우 빈 리스트 생성
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            //처리해야 하는 코스 추가
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }

        //처리해야 하는 노드를 저장하는 변수
        List<Integer> takes = new LinkedList<>();
        // 완료해야 하는 노드 순회
        for (Integer finish : finishToTakeMap.keySet()) {
            if (!dfs(finish, finishToTakeMap, takes)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Integer finish, Map<Integer, List<Integer>> finishToTakeMap, List<Integer> takes) {
        // 완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면
        // 그래프가 순환 구조이므로 false 리턴
        if (takes.contains(finish)) {
            return false;
        }

        // 완료해야 하는 코스에 먼저 처리해야할 노드가 있다면
        if (finishToTakeMap.containsKey(finish)) {
            // 처리해야 하는 노드에 현재 완료해야 하는 노드 추가
            takes.add(finish);

            for (Integer take : finishToTakeMap.get(finish)) {
                if (!dfs(take, finishToTakeMap, takes)) {
                    return false;
                }
            }

            takes.remove(finish);
        }

        return true;

    }
}
