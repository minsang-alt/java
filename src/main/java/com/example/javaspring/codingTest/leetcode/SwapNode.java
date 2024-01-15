package com.example.javaspring.codingTest.leetcode;

public class SwapNode {


    public static void main(String[] args) {
        SwapNode swapNode = new SwapNode();
        ListNode node1 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        swapNode.swapPairs(node1);
    }

    public ListNode swapPairs(ListNode head) {

        ListNode node = new ListNode(0);
        ListNode root = node;
        node.next = head;

        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            ListNode next = b.next;
            b.next = a;
            a.next = next;
            node.next = b;
            node = node.next.next;
        }

        return root.next;

    }
}

