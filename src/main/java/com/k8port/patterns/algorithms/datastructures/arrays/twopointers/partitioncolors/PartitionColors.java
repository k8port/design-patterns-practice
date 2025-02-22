package com.k8port.patterns.algorithms.datastructures.arrays.twopointers.partitioncolors;

import com.k8port.patterns.algorithms.datastructures.arrays.twopointers.TwoPointersAlgorithm;

public class PartitionColors extends TwoPointersAlgorithm<int[], int[]> {

    private int currentPointer;
    private int[] colors;

    @Override
    protected void initializePointers(int[] input) {
        this.colors = input.clone();
        this.leftPointer = 0;
        this.rightPointer = input.length - 1;
        this.currentPointer = 0;
    }

    @Override
    protected boolean isTerminationConditionMet() {
        return this.currentPointer <= this.rightPointer;
    }

    @Override
    protected boolean isSuccessConditionMet() {
        return switch(this.colors[this.currentPointer]) {
            case 0, 1, 2 -> true;
            default -> false;
        };
    }

    @Override
    protected void processSuccessCase() {
        int temp;
        switch(this.colors[this.currentPointer]) {
            case 0 -> {
                temp = this.colors[this.leftPointer];
                this.colors[this.leftPointer] = this.colors[this.currentPointer];
                this.colors[this.currentPointer] = temp;
                this.currentPointer++;
                this.leftPointer++;
            }
            case 1 -> this.currentPointer++;
            case 2 -> {
                temp = this.colors[this.rightPointer];
                this.colors[this.rightPointer] = this.colors[this.currentPointer];
                this.colors[this.currentPointer] = temp;
                this.rightPointer--;
            }
            default -> throw new IllegalArgumentException("Invalid color: " + this.colors[this.currentPointer]);
        }
    }

    @Override
    protected void movePointers() {
        this.currentPointer++;
    }
    
    @Override
    protected int[] getResult() {
        return this.colors;
    }
}
