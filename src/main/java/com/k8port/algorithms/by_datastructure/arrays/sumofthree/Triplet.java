package com.k8port.algorithms.by_datastructure.arrays.sumofthree;


public record Triplet(int first, int second, int third) {
    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", first, second, third);
    }

}
