package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (Integer key : frequentMap.keySet()) {
            int frequency = frequentMap.get(key);
            List<Integer> elems = buckets.getOrDefault(frequency, new ArrayList<>());
            elems.add(key);
            buckets.put(frequency, elems);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int frequency = nums.length; frequency >= 0; frequency--) {
            if (buckets.containsKey(frequency)) {
                List<Integer> elems = buckets.get(frequency);
                for (Integer elem : elems) {
                    if (idx == k) {
                        break;
                    }
                    result[idx] = elem;
                    idx++;
                }
            }
            if (idx == k) {
                break;
            }
        }
        return result;

    }
}
