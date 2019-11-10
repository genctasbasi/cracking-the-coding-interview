package com.escmobile.lab.crackingthecodinginterview.chapter_05_bit_operations;

import com.escmobile.lab.crackingthecodinginterview.NodeG;

public class Queue<T> {

    private NodeG<T> head;
    private NodeG<T> tail;

    public NodeG peek() {
        return head;
    }

    public void queue(NodeG node) {
        if (head == null) {
            head = node;
            return;
        }

        if (tail == null) {
            tail = node;
            tail.right = head;
            return;
        }

        node.right = tail;
        tail = node;
    }

    public NodeG dequeue() {
        if (head == null) {
            return null;
        }

        NodeG node = tail;   // start from tail
        NodeG returnHead;
        while (node.right != null) {

            if (node.right == head) { // next one is head
                returnHead = head;
                head = node;
                head.right = null;
                return returnHead;
            }

            node = node.right;
        }

        return null;
    }
}
