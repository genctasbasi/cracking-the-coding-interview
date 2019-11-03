package com.escmobile.lab.crackingthecodinginterview.chapter_04_trees_graphs;

import com.escmobile.lab.crackingthecodinginterview.Node;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.escmobile.lab.crackingthecodinginterview.Utils.addNode;

public class Test_02_MinimalTree {

    /**
     * Given a sorted (increasing order) array with unique integer elements, write an algorithm
     * to create a binary search tree with minimal height
     * <p>
     * Time complexity:
     * Space complexity:
     */
    @Test
    public void test_4_2_minimal_tree() {
        // Arrange
        List<Integer> list = Arrays.asList(4, 6, 10, 9, 76, 1, 13, 34, 42, 17, 0, 3, 11);
        Node node = null;
        for (Integer item : list) {
            node = addNode(item, node);
        }
    }
}

