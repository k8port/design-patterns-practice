package com.k8port.algorithms.by_datastructure.arrays.sumofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.k8port.algorithms.by_datastructure.arrays.TwoPointersAlgorithm;

public class SumOfThree extends TwoPointersAlgorithm<int[], List<Triplet>> {

    private static final int TARGET_SUM = 0;
    private int[] numbers;
    private List<Triplet> triplets;
    private Set<Integer> seenIntegers;
    private int thirdTripletValue;

    @Override
    protected void initializePointers(int[] input) {
        this.numbers = input.clone();
        Arrays.sort(this.numbers);
        this.triplets = new ArrayList<>();
        this.seenIntegers = new HashSet<>();
        
        // initialize pointers
        this.leftPointer = 0;
        this.rightPointer = this.leftPointer + 1;
        this.thirdTripletValue = TARGET_SUM - this.numbers[this.leftPointer]
                    - this.numbers[this.rightPointer];
    }

    @Override
    protected boolean isTerminationConditionMet() {
        return this.leftPointer >= this.numbers.length - 2;
    }

    @Override
    protected boolean isSuccessConditionMet() {
        if (this.seenIntegers.contains(this.thirdTripletValue)) {
            return true;
        } 
        this.seenIntegers.add(this.numbers[this.rightPointer]);
        return false;
    }


    @Override
    protected void processSuccessCase() {
        this.triplets.add(new Triplet(
            this.numbers[this.leftPointer],
            this.numbers[this.rightPointer],
            this.thirdTripletValue
        ));
    }
    
    @Override
    protected void movePointers() {
        this.rightPointer++;
        this.thirdTripletValue = TARGET_SUM - this.numbers[this.leftPointer]
                                - this.numbers[this.rightPointer];
        if (this.rightPointer >= this.numbers.length - 1) {
            this.leftPointer++;
            this.rightPointer = this.leftPointer + 1;
            this.thirdTripletValue = TARGET_SUM - this.numbers[this.leftPointer]
                                - this.numbers[this.rightPointer];
        }
    }

    @Override
    protected List<Triplet> getResult() {
        return triplets;
    }
    
    
}
