package com.example.javaspring.codingTest.leetcode;

public class MyHashMap {

    static class Node {
        int key;
        int value;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        int index = key % nodes.length;
        if (nodes[index] == null) {
            nodes[index] = newNode;
            return;
        }

        Node node = nodes[index];

        while (node != null) {
            if (node.key == newNode.key) {
                node.value = newNode.value;
                return;
            }
            if (node.next == null) {
                node.next = newNode;
                return;
            }
            node = node.next;
        }

    }

    public int get(int key) {
        int index = key % nodes.length;
        Node node = nodes[index];
        if (node == null) {
            return -1;
        }
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return;
        }
        Node node = nodes[index];
        if (node.key == key) {
            if (node.next == null) {
                nodes[index] = null;
                return;
            }
            nodes[index] = node.next;
        }

        Node prev = node;
        // 연결리스트 삭제
        while (node != null) {
            if (node.key == key) {
                Node tmp = node.next;

                // 추후 GC 성능 문제 해결
                node.next = null;

                prev.next = tmp;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}
