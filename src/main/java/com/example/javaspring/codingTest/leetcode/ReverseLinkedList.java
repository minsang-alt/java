package com.example.javaspring.codingTest.leetcode;

class ListNode {
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

public class ReverseLinkedList {


    public ListNode reverse(ListNode head, ListNode reverseHead) {

        if (head == null) {
            return reverseHead;
        }

        ListNode nx = head.next;
        head.next = reverseHead;

        return reverse(nx, head);
    }

    public static void main(String[] args) {
        ReverseLinkedList rL = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2));
        rL.reverseList(head);
        ListNode head2 = new ListNode(1, new ListNode(2));
        rL.reverList2(head2);
    }

    public ListNode reverseList(ListNode head) {

        ListNode reverseHead = null;
        while (head != null) {
            ListNode nx = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = nx;
        }
        return reverseHead;
    }

    public ListNode reverList2(ListNode head) {
        return reverse(head, null);
    }
}
