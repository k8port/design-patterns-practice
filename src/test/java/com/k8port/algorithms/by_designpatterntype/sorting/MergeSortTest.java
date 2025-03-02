package com.k8port.algorithms.by_designpatterntype.sorting;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for MergeSort implementation
 * Test edge cases and randomly generated arrays
 */
class MergeSortTest {

    private final MergeSort mergeSort = new MergeSort();

    @Test
    @DisplayName("Sort empty array")
    void testEmptyArray() {
        int[] arr = {};
        int[] result = mergeSort.sort(arr);

        assertArrayEquals(new int[] {}, result, "Empty array should stay empty");
    }

    @Test
    @DisplayName("Sort array with single element")
    void testSingleElementArray() {
        int[] arr = {42};
        int[] result = mergeSort.sort(arr);
        
        assertArrayEquals(new int[]{42}, result, "Single element array should stay unchanged");
    }

    @Test
    @DisplayName("Sort already sorted array") 
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = mergeSort.sort(arr);
        
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, result, "Already sorted array should stay sorted");
    }

    @Test
    @DisplayName("Sort reverse-sorted array")
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] result = mergeSort.sort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, result, "Reverse-sorted array should be properly sorted");
    }

    @Test
    @DisplayName("Sort array with duplicate elements")
    void testArrayWithDuplicates() {
        int[] arr = {5, 4, 3, 2, 1, 1, 2, 3, 4, 5};
        int[] result = mergeSort.sort(arr);
        
        assertArrayEquals(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, result, "Array with duplicates should be properly sorted");
    }

    @Test
    @DisplayName("Sort large random array")
    void testLargeRandomArray() {
        Random random = new Random(42); // Use fixed seed for reproducibility
        int size = 1000;
        int[] array = new int[size];
        
        // Fill array with random integers
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000) - 5000; // Range -5000 to 4999
        }
        
        int[] result = mergeSort.sort(array);
        
        // Sort using Java's built-in sort for comparison
        int[] expected = array.clone();
        Arrays.sort(expected);
        
        assertArrayEquals(expected, result, "Large random array should be properly sorted");
    }

    @Test
    @DisplayName("Sort does not modify original array")
    void testOriginalArrayUnmodified() {
        int[] original = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] copy = original.clone();
        mergeSort.sort(original);
        
        assertArrayEquals(copy, original, "Original array should not be modified");
    }

    @Test
    @DisplayName("Sort array with negative numbers")
    void testArrayWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2, -1};
        int[] result = mergeSort.sort(arr);
        assertArrayEquals(new int[] {-5, -4, -3, -2, -1}, result, "Array with negative numbers should be properly sorted");
    }

    @Test
    @DisplayName("Sort handles null input")
    void testNullInput() {
        int[] arr = null;
        assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(arr), "Sorting null array should throw an exception");
    }
    
}
