package com.escmobile.lab.crackingthecodinginterview;

import androidx.annotation.NonNull;

public class LinkedList {

    public Node head;

    public Node addAsHead(int data) {
        Node newHead = new Node();
        newHead.data = data;

        newHead.right = head;
        head = newHead;
        return head;
    }

    Node append(int data) {

        if (head == null) {
            head = new Node();
            head.data = data;
        } else {

            Node n = head;
            while (n.right != null) {
                n = n.right;
            }

            n.right = new Node();
            n.right.data = data;
        }

        return head;
    }

    @NonNull
    @Override
    public String toString() {
        if (head == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(head.data);
        Node node = head;

        while (node.right != null) {
            sb.append(node.data);
            sb.append(" ");
            node = node.right;
        }

        return sb.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
