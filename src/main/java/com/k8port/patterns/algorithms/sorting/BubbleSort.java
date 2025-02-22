package com.k8port.patterns.algorithms.sorting;

public class BubbleSort {
    public int[] sort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        int[] result = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }
}
