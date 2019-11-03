package com.escmobile.lab.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> asList(char[] array) {

        List<Integer> list = new ArrayList<Integer>();

        for (int c : array) {
            list.add(c);
        }

        return list;
    }

    /**
     * Creates a linked list from the elements provided and returns the linkedList
     *
     * @param elements linked list elements
     */
    public static LinkedList createLinkedList(List<Integer> elements) {

        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < elements.size(); i++) {
            linkedList.append(elements.get(i));
        }

        return linkedList;
    }

    public static Node addNode(Integer data, Node node) {

        if (node == null) {
            Node nodeN = new Node();
            nodeN.data = data;
            return nodeN;
        }

        if (data < node.data) {
            node.left = addNode(data, node.left);
            return node;
        } else {
            node.right = addNode(data, node.right);
            return node;
        }
    }

    /**
     * @param lookIn  The string to search in
     * @param lookFor The string to search for
     * @return true if lookIn exits in lookFor
     */
    public static boolean includes(String lookIn, String lookFor) {

        if (lookIn.equalsIgnoreCase(lookFor)) return true;

        int lookForIndex = 0;
        char charLookFor;

        for (int i = 0; i < lookIn.length(); i++) {

            if (lookForIndex >= lookFor.length()) return false;

            char charNow = lookIn.charAt(i);
            charLookFor = lookFor.charAt(lookForIndex);

            if (charNow == charLookFor) {
                lookForIndex++;
            } else {
                charLookFor = 0;
            }
        }

        return true;
    }
}
