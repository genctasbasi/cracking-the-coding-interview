package com.escmobile.lab.crackingthecodinginterview.chapter_04_trees_graphs;

import com.escmobile.lab.crackingthecodinginterview.LinkedListItem;
import com.escmobile.lab.crackingthecodinginterview.Node;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.escmobile.lab.crackingthecodinginterview.Utils.addNode;

public class Test_03_ListOfDepths {

    // key: depth, value: linkedList
    private Map<Integer, LinkedListItem<Integer>> linkedLists = new HashMap();

    /**
     * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
     * (eg if you have a tree with depth D, you'll have D linked lists
     * <p>
     * Time complexity:
     * Space complexity:
     */
    @Test
    public void test_4_3_list_of_depth() {
        // Arrange
        // build the tree first
        // List<Integer> list = Arrays.asList(4, 6, 10, 9, 76, 1, 13, 34, 42, 17, 0, 3, 11);
        List<Integer> list = Arrays.asList(4, 2, 6, 5, 3, 7, 0);
        Node node = null;
        for (Integer item : list) {
            node = addNode(item, node);
        }

        traverse(node, 0);

    }

    /**
     * Breadth order traverse:
     *
     * @param node
     * @return
     */
    int traverse(Node node, int depth) {

        if (node == null) {
            return --depth;
        }

        int depthNow = traverse(node.left, ++depth);

        LinkedListItem<Integer> depthLinkedListItem = linkedLists.get(depthNow);
        xx(node, depthNow, depthLinkedListItem);

        depthNow = traverse(node.right, depthNow);
        xx(node, depthNow, depthLinkedListItem);

        return depthNow;
    }

    private void xx(Node node, int depth, LinkedListItem<Integer> depthLinkedListItem) {
        // TODO: optimize, move out
        if (depthLinkedListItem == null) {  // no linked list yet
            depthLinkedListItem = new LinkedListItem<>();
            depthLinkedListItem.data = node.data;
            linkedLists.put(depth, depthLinkedListItem);
        } else {
            depthLinkedListItem.append(node.data);
        }
    }
}

