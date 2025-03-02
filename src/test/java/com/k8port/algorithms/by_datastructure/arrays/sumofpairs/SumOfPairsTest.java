package com.k8port.algorithms.by_datastructure.arrays.sumofpairs;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SumOfPairsTest {

    @Test
    void shouldFindPairsWithTargetSum() {
        SumOfPairs solver = new SumOfPairs();

        int[] numbers = {};
        int targetSum = 0;
        SumOfPairsInput input = new SumOfPairsInput(numbers, targetSum);

        List<Pair> pairs = solver.execute(input);
        
        assertEquals(4, pairs.size());
        assertTrue(pairs.contains(new Pair(1, 9)));
        assertTrue(pairs.contains(new Pair(2, 8)));
        assertTrue(pairs.contains(new Pair(3, 7)));
        assertTrue(pairs.contains(new Pair(4, 6)));
    }

    @Test
    void shouldHandleEmptyArray() {
        SumOfPairs solver = new SumOfPairs();

        int[] numbers = {};
        int targetSum = 0;
        SumOfPairsInput input = new SumOfPairsInput(numbers, targetSum);

        List<Pair> pairs = solver.execute(input);

        assertTrue(pairs.isEmpty());
    }
}
