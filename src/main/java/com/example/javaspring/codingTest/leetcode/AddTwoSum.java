package com.example.javaspring.codingTest.leetcode;

import java.math.BigInteger;

public class AddTwoSum {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 뒤집은 리스트의 head
        ListNode prev = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public BigInteger toBigInt(ListNode node) {
        String val = "";
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        return new BigInteger(val);
    }

    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null;
        ListNode node = null;

        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // L1, L2 리스트 뒤집기
        ListNode l1reversed = reverseList(l1);
        ListNode l2reversed = reverseList(l2);

        // 더하기 진행
        BigInteger result = toBigInt(l1reversed).add(toBigInt(l2reversed));
        return toReversedLinkedList(result);
    }
}
