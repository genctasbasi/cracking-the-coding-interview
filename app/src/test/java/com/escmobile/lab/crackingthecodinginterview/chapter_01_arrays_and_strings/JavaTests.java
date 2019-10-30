package com.escmobile.lab.crackingthecodinginterview.chapter_01_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.escmobile.lab.crackingthecodinginterview.Utils.asList;

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

    /**
     * Write a method to replace all space in a string with %20.
     * <p>
     * Solution 1: In
     * <p>
     * This is O(n2), there is a better way with O(n): Count the spaces first then loop the array
     * once and move all chars to the end (book solution that I couldn't think!)
     */
    @Test
    public void test_1_3_urlify() {
        String input1 = "Mr John Smith    ";

        int length = 13;
        int lastIndex = length - 1;

        char[] inputCharArr = input1.toCharArray();
        int currentIndex = lastIndex;

        while (currentIndex >= 0) {
            char charNow = inputCharArr[currentIndex];

            if (charNow == ' ') {
                for (int j = lastIndex; j > currentIndex; j--) {
                    // shift 2 chars right
                    inputCharArr[j + 2] = inputCharArr[j];
                }

                inputCharArr[currentIndex] = '%';
                inputCharArr[currentIndex + 1] = '2';
                inputCharArr[currentIndex + 2] = '0';

                length = length + 2;
                lastIndex = length - 1;
            }

            currentIndex--;
        }

        Assert.assertEquals(String.valueOf(inputCharArr), "Mr%20John%20Smith");
    }

    /**
     * Write a method to replace all space in a string with %20.
     * <p>
     * Solution 2: With StringBuilder.
     * This is the cheating option. Apparently I didn't get the question at first. It's just too easy with additional structure.
     */
    @Test
    public void test_1_3_urlify_with_string_builder() {

        String input1 = "Mr John Smith    ";
        int input2 = 13;

        StringBuilder sb = new StringBuilder();

        char[] inputCharArr = input1.toCharArray();

        for (int i = 0; i < input2; i++) {
            char charNow = inputCharArr[i];

            if (charNow == ' ') {
                sb.append("%20");
            } else {
                sb.append(charNow);
            }
        }

        Assert.assertEquals("Mr%20John%20Smith", sb.toString());
    }

    /**
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * Input: Tact Coa
     * Output: True (permutations: "taco cat", "atco cta" etc)
     * <p>
     * Solution: I will count each character. There can several even number counts but only 0 or 1 odd number count
     */
    @Test
    public void test_1_4_palindrome_permutation() {

        String input1 = "Tact Coa";
        char[] inputArray = input1.toLowerCase().toCharArray();
        boolean isPermutation = true;

        // assumption here, discuss with the interviewer.
        // If we cannot make an assumption, we could use lists maybe
        int[] charCounts = new int[128];

        for (char c : inputArray) {
            if (c != ' ')
                charCounts[c] = charCounts[c] + 1;
        }

        boolean hasOdd = false;
        for (int i : charCounts) {
            if (i % 2 == 1) {
                if (hasOdd) { // this is the second odd then, which means it cannot be a permutation
                    isPermutation = false;
                    break;
                }
                hasOdd = true;
            }
        }

        Assert.assertTrue(isPermutation);
    }

    /**
     * Given two strings, write a function to check if they are one edit (or zero edits) away.
     * Edit is: Insert char, remove char, replace char.
     * <p>
     * Example:
     * pale, ple -> true
     * pale, paale -> true
     * pales, pale -> true
     * pale, bale -> true
     * pale, bake -> false
     */
    @Test
    public void test_1_5_one_away() {

        String inputFrom = "pale";
        String inputTo = "ple";

        int changeCount = 0;
        int inputToIndex = 0;
        for (int i = 0; i < inputFrom.length(); i++) {

            char charFrom = inputFrom.charAt(i);
            char charTo = inputTo.charAt(inputToIndex);

            if (charFrom != charTo) {
                changeCount++;

                if (inputFrom.length() == inputTo.length()) {
                    // option 1:
                    // this is the char replacement option.
                    // don't change the inputToIndex. keeping this for readability purposes
                } else if (inputFrom.length() > inputTo.length()) {
                    // option 2:
                    // a char is deleted from inputTo
                    inputToIndex--; // so that indexes match after the deletion
                } else if (inputFrom.length() < inputTo.length()) {
                    // option 3:
                    // a char is added from inputTo
                    inputToIndex++; // so that indexes match after the deletion
                }
            }

            inputToIndex++; // to match inputFrom index (i)
        }

        assert (changeCount <= 1);  // 0 or 1 change is fine
    }

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabccccaaa would become a2b1c5a3. If the compressed string would not become
     * smaller than the original string, your method should return the original string.
     * You can assume the string has only uppercase and lowercase letters (a-z)
     */
    @Test
    public void test_1_6_string_compression() {
        String input = "aabbccccaaa";

        char[] inputArray = input.toCharArray();
        char currentChar = inputArray[0];
        int currentCount = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : inputArray) {

            if (c != currentChar) {
                // char changed
                sb.append(currentChar);
                sb.append(currentCount);

                currentCount = 0;
            }

            currentCount++;
            currentChar = c;
        }

        sb.append(currentChar);
        sb.append(currentCount);

        Assert.assertEquals("a2b2c4a3", sb.toString());
    }
}
