package com.example.javaspring.codingTest.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStack {
    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            Queue<Integer> queue1 = new LinkedList<>();
            queue1.add(x);
            while (!queue.isEmpty()) {
                queue1.add(queue.poll());
            }
            queue = queue1;
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.element();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
