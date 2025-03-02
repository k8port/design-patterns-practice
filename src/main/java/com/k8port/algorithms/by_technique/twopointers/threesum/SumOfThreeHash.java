package com.k8port.algorithms.by_technique.twopointers.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * HashSet implementation of the sum of three problem.
 */
public class SumOfThreeHash {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumOfThreeHash.class);

    public List<List<Integer>> findTripletsWithZeroSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;

           Set<Integer> seen = new HashSet<>();
           for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                    triplets.add(Arrays.asList(nums[i], nums[j], complement));
                }
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        SumOfThreeHash sumOfThreeHash = new SumOfThreeHash();
        String testString = "Triplets with zero sum: {}";
        int[] nums = {-1, 0, 1, 2, -1, -4};
        LOGGER.info(testString, sumOfThreeHash.findTripletsWithZeroSum(nums));

        SumOfThreeHash sumOfThreeHash2 = new SumOfThreeHash();
        int[] nums2 = {0, 0, 0, 0};
        LOGGER.info(testString, sumOfThreeHash2.findTripletsWithZeroSum(nums2));

        SumOfThreeHash sumOfThreeHash3 = new SumOfThreeHash();
        int[] nums3 = {-2, 0, 1, 1, 2};
        LOGGER.info(testString, sumOfThreeHash3.findTripletsWithZeroSum(nums3));

        SumOfThreeHash sumOfThreeHash4 = new SumOfThreeHash();
        int[] nums4 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        LOGGER.info(testString, sumOfThreeHash4.findTripletsWithZeroSum(nums4));
    }   
}