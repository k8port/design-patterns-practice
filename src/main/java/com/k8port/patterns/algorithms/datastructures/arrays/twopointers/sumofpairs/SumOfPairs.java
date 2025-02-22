package com.k8port.patterns.algorithms.datastructures.arrays.twopointers.sumofpairs;

import java.util.ArrayList;
import java.util.List;

import com.k8port.patterns.algorithms.datastructures.arrays.twopointers.TwoPointersAlgorithm;

public class SumOfPairs extends TwoPointersAlgorithm<SumOfPairsInput, List<Pair>> {

    private int[] numbers;
    private int targetSum;
    private List<Pair> pairs;

    @Override
    protected void initializePointers(SumOfPairsInput input) {
        this.numbers = input.numbers();
        this.targetSum = input.targetSum();
        this.pairs = new ArrayList<>();
        this.leftPointer = 0;
        this.rightPointer = numbers.length - 1;
    }

    @Override
    protected boolean isTerminationConditionMet() {
        return leftPointer >= rightPointer;
    }

    @Override
    protected boolean isSuccessConditionMet() {
        return numbers[leftPointer] + numbers[rightPointer] == targetSum;
    }

    @Override
    protected void processSuccessCase() {
        pairs.add(new Pair(numbers[leftPointer], numbers[rightPointer]));
        leftPointer++;  
        rightPointer--;
    }

    @Override
    protected void movePointers() {
        if (numbers[leftPointer] + numbers[rightPointer] < targetSum) {
            leftPointer++;
        } else {
            rightPointer--;
        }
    }

    @Override
    protected List<Pair> getResult() {
        return pairs;
    }
}