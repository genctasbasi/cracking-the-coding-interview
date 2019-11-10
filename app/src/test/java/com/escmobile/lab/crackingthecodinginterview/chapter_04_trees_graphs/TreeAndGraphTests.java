package com.escmobile.lab.crackingthecodinginterview.chapter_04_trees_graphs;

import com.escmobile.lab.crackingthecodinginterview.Node;
import com.escmobile.lab.crackingthecodinginterview.NodeG;
import com.escmobile.lab.crackingthecodinginterview.SampleGraph;
import com.escmobile.lab.crackingthecodinginterview.Vertex;
import com.escmobile.lab.crackingthecodinginterview.chapter_05_bit_operations.Queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static com.escmobile.lab.crackingthecodinginterview.Utils.addNode;
import static com.escmobile.lab.crackingthecodinginterview.Utils.createBST;

public class TreeAndGraphTests {

    private int visitsMade = 0;

    /**
     * Given a directed graph, design an algorithm to find out whether there is a no route between two nodes.
     */
    @Test
    public void test_4_1_route_between_nodes() {
        // Arrange
        SampleGraph graph = new SampleGraph();

        // 1 check if there is route from vertex 1 to vertex 3
        Vertex vFrom = graph.getVertices().get(0);
        Vertex vEnd = graph.getVertices().get(5);

        boolean hasRoute = visitDFS(vFrom, vEnd);

        assert (hasRoute);
        assert (visitsMade == 5);
    }

    boolean visitDFS(Vertex vStart, Vertex vEnd) {

        if (vStart == vEnd) {
            return true;
        }

        if (vStart.visited) return vEnd.visited;

        vStart.visited = true;
        visitsMade++;

        for (Vertex vNeighbour : vStart.vertices) {
            if (!vNeighbour.visited) {
                boolean result = visitDFS(vNeighbour, vEnd);
                if (result) return true;

            }
        }

        return vEnd.visited;
    }

    @Test
    public void bfs_traverse() {

        // Arrange
        SampleGraph graph = new SampleGraph();

        // 1 check if there is route from vertex 1 to vertex 3
        Vertex vStart = graph.getVertices().get(0);
        visitBFS(vStart, new Queue<NodeG<Vertex>>(), new ArrayList<Vertex>());

    }

    /**
     * BFS is implemented with a queue.
     * The logic is, finish visiting a node's all neighbours before moving to it's children
     *
     * @param vertex
     * @param queue
     */
    private void visitBFS(Vertex vertex, Queue<NodeG<Vertex>> queue, List<Vertex> visitedVertices) {

        if (!vertex.visited) {
            vertex.visited = true;
            visitedVertices.add(vertex);
        }

        for (Vertex v : vertex.vertices) {
            if (!v.visited)
                queue.queue(new NodeG(v));
        }

        NodeG<Vertex> next = queue.dequeue();
        Vertex nextV = next.data;

        visitBFS(nextV, queue, visitedVertices);
    }

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
        List<Integer> list = Arrays.asList(0, 2, 5, 7, 9, 11, 14, 15, 19, 21, 24); // 11
        List<Integer> list2 = Arrays.asList(0, 2, 5, 7, 9, 11, 14, 15, 19, 21); // 10

        int index = list.size() / 2;    // 5
        Node node = addNode(list.get(index), null);

        for (int i = 1; i < index; i++) {
            int nR = list.get(index + i);
            int nL = list.get(index - i);

            addNode(nR, node);
            addNode(nL, node);
        }
    }

    @Test
    public void test_4_3_list_of_depth() {

        // Arrange
        // Create sample BST first
        List<Integer> list = Arrays.asList(11, 5, 15, 3, 7, 13, 18);
        Node head = createBST(list);

        Map<Integer, Set<Integer>> depthMap = new HashMap<>();

        traverse(head, depthMap, 0);
    }

    private void traverse(Node node, Map<Integer, Set<Integer>> depthMap, int depth) {

        if (node == null) {
            return;
        }

        addToList(depth, node.data, depthMap);

        int nextDepth = ++depth;

        traverse(node.left, depthMap, nextDepth);
        traverse(node.right, depthMap, nextDepth);

    }

    private void addToList(int depth, int value, Map<Integer, Set<Integer>> depthMap) {

        if (!depthMap.containsKey(depth)) {
            depthMap.put(depth, new HashSet<Integer>());
        }

        Objects.requireNonNull(depthMap.get(depth)).add(value);
    }

    /**
     * left and right height should not differ by more than one
     */
    @Test
    public void test_4_4_check_balanced() {

        // Arrange
        // Create sample BST first
        List<Integer> list = Arrays.asList(11, 5, 15, 3, 7, 13, 18, 0, 90, 99, 101);
        Node head = createBST(list);

        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);

        assert Math.abs(leftHeight - rightHeight) <= 1;

    }

    private int getHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return left > right ? left + 1 : right + 1;
    }

    /**
     * check if a binary tree is a binary search tree
     */
    @Test
    public void test_4_5_validate_bst() {
        // create a failure test:
        // valid binary tree:
        List<Integer> list = Arrays.asList(11, 5, 15, 3, 7, 13, 18, 0, 90, 99, 101);
        Node validTree = createBST(list);

        Node invalidTree = createBST(list);
        invalidTree.left.left.data = 500;

        boolean isValid1 = isValid(validTree);
        boolean isValid2 = isValid(invalidTree);

        assert (isValid1);
        assert (!isValid2);
    }

    private boolean isValid(Node node) {

        if (node == null)
            return true;

        boolean isLeftValid = isValid(node.left);
        boolean isRightValid = isValid(node.right);

        return isLeftValid && isRightValid
                && (node.left == null || node.data >= node.left.data)
                && (node.right == null || node.data <= node.right.data);
    }

    /**
     * find 'next' node in BST
     */
    @Test
    public void test_4_6_find_next_in_bst() {
        List<Integer> list = Arrays.asList(11, 5, 15, 3, 7, 13, 18, 0, 90, 99, 12, 6, 9);
        Node head = createBST(list);

        Node nextNode = getNextNode(head.left);

        assert (nextNode != null && nextNode.data == 12);
    }

    /**
     * next node is the left most node of the right subtree
     *
     * @param node
     * @return
     */
    private Node getNextNode(Node node) {

        Node next = node.right;
        if (next == null) return node;

        while (true) {

            if (next.left == null) {
                return next;
            }

            next = next.left;
        }
    }

    @Test
    public void test_4_7_build_order() {

        List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<ProjectDependency> dependencies = Arrays.asList(
                new ProjectDependency("a", "d"),
                new ProjectDependency("f", "b"),
                new ProjectDependency("b", "d"),
                new ProjectDependency("f", "a"),
                new ProjectDependency("d", "c")
        );

        // f, e, a, b, , c

        // Solution:
        // This will best be represented by a graph. Create the graph first, nodes being the projects
        // end edges being the dependencies. Then start from one node, assign an arbitrary point (ie 100). Then for each node
        // depending on this node, reduce the point less than the depending one. So if dependency is like c -> b -> a, and all three
        // started with 100 points, then they will end up c being 100 (nothing depends on it) b is 90 (c depends on it) and a is 80 (both b and c depends)
        // That way, once all nodes are visited, we can sort them by their points ascending ie a, b, c; which gives us the build order.
        // No, I'm not going to implement this :)
    }

    class ProjectDependency {
        String project;
        String dependent;

        ProjectDependency(String project, String dependent) {
            this.project = project;
            this.dependent = dependent;
        }
    }

    /**
     * not BST - just binary.
     */
    @Test
    public void test_4_8_first_common_ancestor_in_binary_tree() {

        List<Integer> list = Arrays.asList(11, 5, 15, 3, 7, 13, 18, 0, 90, 99, 12, 6, 9);
        Node head = createBST(list);

        // make it non-BST
        head.right.right.data = 1;

        Node common = getFirstCommonAncestor(head, head.right.left.left, head.right.right.right.right);

        assert (common.data == 15);
    }

    private Node getFirstCommonAncestor(Node currentCommon, Node node1, Node node2) {

        boolean isLeftCommon = isCommon(currentCommon.left, node1, node2);
        boolean isRightCommon = isCommon(currentCommon.right, node1, node2);

        if (isLeftCommon) {
            return getFirstCommonAncestor(currentCommon.left, node1, node2);
        } else if (isRightCommon) {
            return getFirstCommonAncestor(currentCommon.right, node1, node2);
        }

        return currentCommon;
    }

    private boolean isCommon(Node head, Node node1, Node node2) {

        boolean isNode1Child = isChild(head, node1);
        boolean isNode2Child = isChild(head, node2);

        return isNode1Child && isNode2Child;
    }

    private boolean isChild(Node head, Node child) {

        if (head == null || child == null)
            return false;

        if (head.data == child.data)
            return true;

        boolean hasLeft = isChild(head.left, child);
        boolean hasRight = isChild(head.right, child);

        return hasLeft || hasRight;
    }
}

