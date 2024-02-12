package com.example.javaspring.codingTest.leetcode;

public class MyCircularDeque {

    static class DoubleLinkedList {

        int val;
        DoubleLinkedList right;
        DoubleLinkedList left;

        public DoubleLinkedList(int val) {
            this.val = val;
        }
    }


    // 현재 데큐 사이즈
    int len;
    // 데큐 총 사이즈
    int k;
    DoubleLinkedList head;
    DoubleLinkedList tail;

    public MyCircularDeque(int k) {
        this.k = k;
        head = new DoubleLinkedList(0);
        tail = new DoubleLinkedList(0);
        head.right = tail;
        tail.left = head;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(value);

        DoubleLinkedList next = head.right;
        head.right = doubleLinkedList;
        doubleLinkedList.left = head;
        doubleLinkedList.right = next;
        next.left = doubleLinkedList;

        len++;
        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        DoubleLinkedList node = new DoubleLinkedList(value);
        node.left = tail.left;
        node.right = tail;
        tail.left.right = node;
        tail.left = node;

        len++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        DoubleLinkedList node = head.right;
        head.right = node.right;
        node.right.left = node.left;

        len--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail.left = tail.left.left;
        tail.left.right = tail;

        len--;
        return true;
    }

    public int getFront() {
        return len != 0 ? head.right.val : -1;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.left.val;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == k;
    }
}
