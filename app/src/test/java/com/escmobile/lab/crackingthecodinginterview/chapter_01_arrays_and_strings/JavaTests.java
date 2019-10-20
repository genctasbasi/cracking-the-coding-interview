package com.escmobile.lab.crackingthecodinginterview.chapter_01_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaTests {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    @Test
    public void test_1_1_is_unique() {

        // Arrange
        String testStringPositive = "THIsShouldWORK";
        String testStringNegative = "the cat sat on the mat";

        Set<Character> charSets = new HashSet<>();
        // Act
        boolean isFound = false;
        for (int i = 0; i < testStringPositive.length(); i++) {

            char charNow = testStringPositive.charAt(i);
            if (charSets.contains(charNow)) {
                isFound = true;
                break;
            }

            charSets.add(charNow);
        }

        // Assert
        Assert.assertFalse(isFound);
    }

    /**
     * Solution 1
     * <p>
     * Given two string, write a method to decide if one is a permutation of the other.
     * <p>
     * Solution: 2 strings are perm of each other if they have same characters but in different order
     */
    @Test
    public void test_1_2_check_permutation_1() {

        String string1 = "something";
        String string2 = "osginehtm";

        boolean isPerm = false;

        if (string1.length() != string2.length()) {
            assert (false);
            return;
        }

        List<Integer> string2List = asList(string2.toCharArray());

        for (int i = 0; i < string1.length(); i++) {

            int charNow = string1.charAt(i);

            if (string2List.contains(charNow)) {
                string2List.remove((Integer) charNow);
            } else {
                isPerm = false;
                break;
            }
        }

        isPerm = string2List.isEmpty();

        assert (isPerm);
    }

    /**
     * Solution 2
     * <p>
     * Given two string, write a method to decide if one is a permutation of the other.
     * <p>
     * Solution: 2 strings are perm of each other if they have same characters but in different order
     */
    @Test
    public void test_1_2_check_permutation_2() {

        String string1 = "something";
        String string2 = "osginehtm";

        char[] string1Array = new char[128];    // we assume the string limit

        for (char c : string1.toCharArray()) {
            string1Array[c] += 1;
        }

        for (char c : string2.toCharArray()) {
            string1Array[c] -= 1;
        }

        // string1Array should be empty now
        for (char c : string1Array) {
            if (c != 0) {
                assert (false);
                return;
            }
        }

        assert (true);
    }

    List<Integer> asList(char[] array) {

        List<Integer> list = new ArrayList<Integer>();

        for (int c : array) {
            list.add(c);
        }

        return list;
    }

    @Test
    public void test_includes() {
        String string1 = "one sting ole str another";
        String string2 = "e str";

        boolean isPerm = false;

        if (string1.equalsIgnoreCase(string2)) {
            assert (isPerm);
            return;
        }

        String lookIn;
        String lookFor;

        if (string1.length() > string2.length()) {
            lookIn = string1;
            lookFor = string2;
        } else {
            lookIn = string2;
            lookFor = string1;
        }

        int lookForIndex = 0;
        char charLookFor;

        for (int i = 0; i < lookIn.length(); i++) {

            if (lookForIndex >= lookFor.length()) {
                isPerm = true;
                break;
            }

            char charNow = lookIn.charAt(i);
            charLookFor = lookFor.charAt(lookForIndex);

            if (charNow == charLookFor) {
                lookForIndex++;
            } else {
                charLookFor = 0;
            }
        }

        assert (isPerm);
    }
}
