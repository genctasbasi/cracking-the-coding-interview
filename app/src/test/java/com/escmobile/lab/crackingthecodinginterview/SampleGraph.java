package com.escmobile.lab.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class SampleGraph {

    private List<Vertex> vertices;

    public List<Vertex> getVertices() {
        return vertices;
    }

    public SampleGraph() {
        create();
    }

    void create() {

        // create vertices
        createVertices();

        // create edges
        createEdges();
    }

    private void createEdges() {
        vertices.get(0).vertices.add(vertices.get(1));
        vertices.get(0).vertices.add(vertices.get(2));
        vertices.get(1).vertices.add(vertices.get(2));
        vertices.get(2).vertices.add(vertices.get(3));
        vertices.get(3).vertices.add(vertices.get(4));
        vertices.get(4).vertices.add(vertices.get(1));
        vertices.get(4).vertices.add(vertices.get(2));
    }

    private void createVertices() {
        vertices = new ArrayList<>();

        vertices.add(new Vertex(0));
        vertices.add(new Vertex(1));
        vertices.add(new Vertex(2));
        vertices.add(new Vertex(3));
        vertices.add(new Vertex(4));
        vertices.add(new Vertex(5));
    }

}
