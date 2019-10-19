package com.escmobile.lab.crackingthecodinginterview.chapter_01_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class JavaTests {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     *
     * Complexity: O(n)
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
}
