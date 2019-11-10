package com.escmobile.lab.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public int data;

    Vertex(int data) {
        this.data = data;
    }

    public List<Vertex> vertices = new ArrayList<>();
    public boolean visited = false;
}
