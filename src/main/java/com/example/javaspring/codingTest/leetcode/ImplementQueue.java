package com.example.javaspring.codingTest.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueue {

    private Deque<Integer> stack = new ArrayDeque<>();

    public ImplementQueue() {

    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        int result = stack2.element();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return result;

    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
