package com.k8port.patterns.algorithms.datastructures.arrays.twopointers.sumofpairs;

import java.util.Arrays;

public record SumOfPairsInput(int[] numbers, int targetSum) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumOfPairsInput that = (SumOfPairsInput) o;
        return targetSum == that.targetSum && Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return 31 * Arrays.hashCode(numbers) + Integer.hashCode(targetSum);
    }

    @Override
    public String toString() {
        return "SumOfPairsInput[numbers=" + Arrays.toString(numbers) + ", targetSum=" + targetSum + "]";
    }
}

