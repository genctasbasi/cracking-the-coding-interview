package com.escmobile.lab.crackingthecodinginterview.chapter_02_linked_lists;

import com.escmobile.lab.crackingthecodinginterview.LinkedList;
import com.escmobile.lab.crackingthecodinginterview.Node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.escmobile.lab.crackingthecodinginterview.Utils.createLinkedList;

public class LinkedListTests {

    private LinkedList linkedList = createLinkedList(Arrays.asList(2, 12, 2, 14, 18, 12, 90, 5, 9, 4, 3, 100, 101, 14, 3));

    /**
     * Write code to remove the duplications from an unsorted linked list
     */
    @Test
    public void test_2_1_remove_duplications() {

        if (linkedList.isEmpty()) return;

        List<Integer> nodesVisited = new ArrayList<>();

        Node node = linkedList.head;
        nodesVisited.add(node.data);

        while (node.right != null) {

            if (nodesVisited.contains(node.right.data)) {
                node.right = node.right.right;
            } else {
                nodesVisited.add(node.right.data);

                node = node.right;
            }
        }
    }

    /**
     * Write code to remove the duplications from an unsorted linked list without using an array
     */
    @Test
    public void test_2_1_remove_duplications_no_array() {

        // 2, 12, 2, 14, 18, 12, 90, 5, 9, 4, 3, 100, 101, 14, 3
        if (linkedList.isEmpty()) return;

        Node p1 = linkedList.head;
        Node p2 = p1;

        while (p1 != null) {

            while (p2.right != null) {

                if (p1.data == p2.right.data) {
                    // duplication
                    p2.right = p2.right.right;
                    break;
                }

                p2 = p2.right;
            }

            p1 = p1.right;
            p2 = p1;
        }
    }

    /**
     * Find the kth to last element of a singly linked list
     */
    @Test
    public void test_2_2_kth_to_last() {

        int k = 4;
        if (linkedList.isEmpty()) return;
    }

    /**
     * Delete the element in the middle, having only access to that one
     */
    @Test
    public void test_2_3_delete_element_in_the_middle() {

        // Arrange
        LinkedList testLinkedList = createLinkedList(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

        // get to element #3, the one to delete

        // assumption: we know this node is in the middle (ie there is at least one node on the right)
        Node node = testLinkedList.head.right.right.right;

        while (node.right != null) {
            node.data = node.right.data;

            if (node.right.right == null) { // then hit the end, drop the last node
                node.right = null;
                break;
            }

            node = node.right;

        }


    }

    @Test
    public void test_2_5_sum_links() {
        // Arrange
        LinkedList testLinkedList1 = createLinkedList(Arrays.asList(2, 4, 5));
        LinkedList testLinkedList2 = createLinkedList(Arrays.asList(6, 1, 7));

        String sum1 = getLinkedListAsReverseString(testLinkedList1.head);
        String sum2 = getLinkedListAsReverseString(testLinkedList2.head);

        // Assumption: sum1 and sum2 are parsable, no checks in place
        Integer sum = Integer.parseInt(sum1) + Integer.parseInt(sum2);
    }

    /**
     * gets head of a linked list {1, 2, 3} and returns as reverse string ie "321"
     *
     * @param node head node
     * @return
     */
    private String getLinkedListAsReverseString(Node node) {

        if (node.right == null) {
            return String.valueOf(node.data);
        }

        return getLinkedListAsReverseString(node.right) + node.data;
    }

    @Test
    public void test_2_6_palindrome() {

        // Arrange
        LinkedList testLinkedList = createLinkedList(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

        // Node reversedHead = reverseAndClone(testLinkedList.head);
        // Node reversedHead = reverseRecursive(testLinkedList.head);
        Node reversedIterative = reverseIterative(testLinkedList.head);

    }

    @Test
    public void test_2_8_loop_detection() {
        // Arrange - create the corrupted linkedlist
        LinkedList testLinkedList = createLinkedList(Arrays.asList(0, 1, 2, 3, 4));
        testLinkedList.head.right.right.right.right.right = testLinkedList.head.right;  // 4 loops to 1

        Node head1 = testLinkedList.head;
        Node head2 = testLinkedList.head.right;
        Node loopStartsAt = null;

        while (true) {

            if (head1.right == head2.right.right) {
                loopStartsAt = head2;
                break;

            }

            head1 = head1.right;
            head2 = head2.right.right;

        }

        // Assert
        assert (loopStartsAt.data == 1);
    }

    /**
     * Reverses a linked list
     *
     * @param node
     * @return
     */
    private Node reverseAndClone(Node node) {

        Node currentHead = new Node();
        currentHead.data = node.data;

        while (node.right != null) {
            Node newNode = new Node();
            newNode.data = node.right.data;
            newNode.right = currentHead;
            currentHead = newNode;

            node = node.right;
        }

        return currentHead;
    }

    Node temp;

    /**
     * {0, 1, 2, 3, 4, 5, 6}
     */
    private Node reverseRecursive(Node node) {

        if (node.right == null) {
            temp = node;
            return node;
        }

        Node nodeNew = reverseRecursive(node.right);
        nodeNew.right = node;
        node.right = null;
        // nodeNew.temp = node;

        return node;
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6}
     * {0, 1}
     */
    private Node reverseIterative(Node node) {

        if (node == null || node.right == null) return node;

        Node current = node;
        Node next1 = node.right;
        Node next2 = next1.right;

        node.right = null;  // the first one

        while (next1 != null) {

            // current.right = null;
            next1.right = current;

            current = next1;
            next1 = next2;

            if (next2 != null)
                next2 = next2.right;

        }

        return current;

    }
}