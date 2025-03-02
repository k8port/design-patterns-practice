package com.k8port.algorithms.by_designpatterntype.sorting;

/**
 * Implementaion of Merge Sort algorithm
 * Uses divide and conquer strategy:
 * 1. Divide: Split array into two halves
 * 2. Conquer: Recursively sort each half
 * 3. Combine: Merge sorted halves
 * 
 * Stable sort: preserves relative order of equal elements
 * Not in-place: requires additional array for merging
 * 
 * Time Complexity:
 * Best: O(n log n)
 * Average: O(n log n)
 * Worst: O(n log n)
 * 
 * Space Complexity: O(n)
 */
public class MergeSort {

    /**
     * Sort input array using merge sort
     * method creates copy of array and sorts without modifying original
     * @param arr array to sort
     * @return sorted array
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int[] result = arr.clone();

        // call recursive merge sort
        mergeSort(result, 0, result.length - 1);

        return result;
    }

    /**
     * Recursive merge sort implementation
     * @param arr array to sort
     * @param left left index of subarray
     * @param right right index of subarray
     */
    private void mergeSort(int[] arr, int left, int right) {
        // base case: subarray has 0-1 elements and already sorted
        if (left >= right) {
            return;
        }

        // find middle index to divide array in half
        int middle = left + (right - left) / 2;  // avoids potential overflow

        // recursively sort each half
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        // merge sorted halves
        merge(arr, left, middle, right);
    }

    /**
     * Merges 2 sorted subarrays
     * @param arr array containing subarrays
     * @param left start index of first subarray
     * @param middle end index of first subarray
     * @param right end index of second subarray
     */
    private void merge(int[] arr, int left, int middle, int right) {
        // calculate size of subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // create temp arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < leftArray.length; i++) {
           leftArray[i] = arr[left + i]; 
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        //  merge temp arrays
        int i = 0, j = 0; // initial indices of subarrays
        int k = left; // initial index of merged subarray

        // compare elements from subarrays and place smaller first
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // copy remaining elements of rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
