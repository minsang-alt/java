package com.example.javaspring.codingTest.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Palindrom {

    class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        // 데크가 모두 비거나(짝수개수) 1개 이하(홀수 개일때)가 될때까지 비교
        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
