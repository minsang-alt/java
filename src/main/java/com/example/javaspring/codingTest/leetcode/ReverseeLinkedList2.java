package com.example.javaspring.codingTest.leetcode;

public class ReverseeLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = root;

        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        ListNode end = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = end.next;
            ListNode tmp1 = start.next;
            start.next = tmp;
            end.next = tmp.next;
            tmp.next = tmp1;
        }
        return head;
    }
}
