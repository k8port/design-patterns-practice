package com.k8port.algorithms.by_designpatterntype.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
    private final BubbleSort sorter = new BubbleSort();

    @Test
    void shouldSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        sorter.sort(input);
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void shouldSortArrayWithOneElement() {
        int[] input = {1};
        int[] expected = {1};
        sorter.sort(input);
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void shouldSortUnsortedArray() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        sorter.sort(input);
        assertArrayEquals(expected, sorter.sort(input));
    }
}
