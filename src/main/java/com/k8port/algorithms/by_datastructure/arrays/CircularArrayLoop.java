package com.k8port.algorithms.by_datastructure.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircularArrayLoop {
    private static final Logger LOGGER = LoggerFactory.getLogger(CircularArrayLoop.class);

    /**
     * Given a circular array of integers, determine if loop exists.
     * @param nums - circular array of non-zero integers
     * @return true if valid cycle exists, false otherwise
     */
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            if (hasCycle(nums, i)) return true;
            markVisited(nums, i);
        }
        return false;
    }

    private static boolean hasCycle(int[] nums, int start) {
        boolean isForward = nums[start] > 0;
        int slow = start;
        int fast = start;

        while (true) {
            slow = getNextIndex(nums, isForward, slow);
            if (slow == -1) return false;

            fast = getNextIndex(nums, isForward, fast);
            if (fast == -1) return false;

            fast = getNextIndex(nums, isForward, fast);
            if (fast == -1) return false;

            if (slow == fast) {
                return slow != getNextIndex(nums, isForward, slow);
            }
        }
    }

    private static void markVisited(int[] nums, int start) {
        int slow = start;
        int val = nums[start];
        while (nums[slow] * val > 0) {
            int next = getNextIndex(nums, val > 0, slow);
            nums[slow] = 0;
            if (next == -1) break;
            slow = next;
        }
    }

    /**
     * Get next index in circular array.
     * @param nums - array of integers
     * @param isForward - direction flag (true if moving forward, false otherwise)
     * @param currentIndex - current index in array
     * @return next index or -1 if invalid
     */
    private static int getNextIndex(int[] nums, boolean isForward, int currentIndex) {
        // check current step direction
        boolean direction = nums[currentIndex] > 0;
        if (isForward != direction) return -1;

        int n = nums.length;
        int next = (currentIndex + nums[currentIndex]) % n;
        // handle negative modulo
        if (next < 0) next += n;

        // check for self-loop
        if (next == currentIndex) return -1;

        return next;
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {1, 3, -2, -4, 1},
            {2, 1, -1, -2},
            {5, 4, -2, -1, 3},
            {1, 2, -3, 3, 4, 7, 1},
            {3, 3, 1, -1, 2}
        };
        boolean[] expected = {true, false, true, false, false};

        for (int i = 0; i < inputs.length; i++) {
            boolean result = circularArrayLoop(inputs[i]);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Input: {}", Arrays.toString(inputs[i]));
                LOGGER.info("Expected: {}, Result: {}", expected[i], result);
            }
        }
    }
}
