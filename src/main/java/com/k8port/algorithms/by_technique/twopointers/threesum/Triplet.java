package com.k8port.algorithms.by_technique.twopointers.threesum;


public record Triplet(int first, int second, int third) {
    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", first, second, third);
    }

}
