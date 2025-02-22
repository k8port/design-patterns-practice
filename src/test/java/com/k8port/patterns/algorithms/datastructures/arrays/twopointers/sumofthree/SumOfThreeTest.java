package com.k8port.patterns.algorithms.datastructures.arrays.twopointers.sumofthree;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SumOfThreeTest {

    private final SumOfThree solver = new SumOfThree();

    @Test
    void shouldFindBasicTriplets() {
        int[] numbers = new int[] {-1, 0, 1, 2, -1, -4};
        List<Triplet> result = solver.execute(numbers);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Triplet(-1, 0, 1)));
        assertTrue(result.contains(new Triplet(-1, -1, 2)));
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] numbers = {};
        List<Triplet> result = solver.execute(numbers);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleNoTriplets() {
        int[] numbers = {1, 2, 3, 4, 5};
        List<Triplet> result = solver.execute(numbers);

        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleDuplicateTriplets() {
        int[] numbers = {-2, 0, 0, 2, 2};
        List<Triplet> result = solver.execute(numbers);
        assertEquals(2, result.size());

        assertTrue(result.contains(new Triplet(-2, 0, 2)));
        assertTrue(result.contains(new Triplet(0, 0, 0)));
    }

    @Test
    void shouldHandleAllZeroes() {
        int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Triplet> result = solver.execute(numbers);
        assertEquals(0, result.size());
    }
}   
