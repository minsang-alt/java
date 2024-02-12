package com.example.javaspring.codingTest.leetcode;

public class MyCircularQueue {
    private int size;
    private int[] queue;

    private int start;
    private int end;

    public MyCircularQueue(int k) {
        start = 0;
        end = -1;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        end = (end + 1) % queue.length;
        queue[end] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        start = (start + 1) % queue.length;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[start];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[end];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {

        return queue.length == size;
    }
}
