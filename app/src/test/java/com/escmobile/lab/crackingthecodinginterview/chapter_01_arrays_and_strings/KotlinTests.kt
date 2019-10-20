package com.escmobile.lab.crackingthecodinginterview.chapter_01_arrays_and_strings

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KotlinTests {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    @Test
    fun test_1_1_is_unique() {

        // Arrange
        val testStringPositive = "THIsShouldWORK"
        val testStringNegative = "TheCatSatOnTheMat"

        // Act
        val arrPositive = testStringPositive.groupBy { it }
        val arrNegative = testStringNegative.groupBy { it }

        // Assert
        assertTrue(arrPositive.values.maxBy { it.size }?.size ?: 0 == 1)
        assertFalse(arrNegative.values.maxBy { it.size }?.size ?: 0 == 1)
    }
}
