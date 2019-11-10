package com.escmobile.lab.crackingthecodinginterview;

/**
 * Node - generic version
 *
 * @param <T>
 */
public class NodeG<T> {
    public T data;
    public NodeG left;
    public NodeG right;

    public NodeG() {
    }

    public NodeG(T data) {
        this.data = data;
    }
}
