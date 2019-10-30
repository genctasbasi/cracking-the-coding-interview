package com.escmobile.lab.crackingthecodinginterview;

public class LinkedListItem<T> {

    private LinkedListItem<T> next;
    public T data;

    public void append(T data) {

        if (next == null) {
            next = new LinkedListItem<>();
            next.data = data;
        } else {
            while (next.next != null) {
                next = next.next;
            }

            next.next = new LinkedListItem<>();
            next.next.data = data;
        }
    }
}



