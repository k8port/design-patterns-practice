package com.k8port.algorithms.by_datastructure.strings.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepeatedDNASequences {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatedDNASequences.class);

    /**
     * Given a string s that represents a DNA sequence, return all the 10-letter
     * -long sequences (substrings) that occur more than once in the sequence.
     * naive approach
     * @param s the DNA sequence
     * @k length of repeated sequences
     */
    public static Set<String> findRepeatedDnaSequences(String s, int k) {
        Set<String> visited = new HashSet<>();
        ArrayList<String> repeatedSequences = new ArrayList<>();
        int n = s.length();
        int count = 0;
        while(count < n - k + 1) {
            String sequence = s.substring(count, count + k);
            if (visited.contains(sequence)) {
                repeatedSequences.add(sequence);
            } else {
                visited.add(sequence);
            }
            count++;
        } 

        return new HashSet<>(repeatedSequences);
    }


    public static Set<String> findRepeatedDnaSequencesOptimized(String s, int k) {
        int strLen = s.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);


        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[strLen]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < strLen; i++) {
            numbers.set(i, map.get(s.charAt(i)));
        }

        // H=c1*a^(k-1) + c2*a^(k-2) + ... + ck*a^0
        int baseValue = 4; // base value is a
        int hashValue = 0;
        Set<Integer> hashes = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < strLen - k + 1; i++) {
            // when window is at initial position caculate hash from scratch
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(baseValue, k - j - 1);
                }
            } else {
                // when window is not at initial position, calculate hash from previous hash value
                int prevHash = hashValue;
                hashValue = ((prevHash - numbers.get(i - 1) * (int) Math.pow(baseValue, k - 1)) * baseValue) + numbers.get(i + k - 1);
            }
            if (hashes.contains(hashValue)) {
                result.add(s.substring(i, i + k));
            } else {
                hashes.add(hashValue);
            }
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("\n\tHash value of {}: {}", s.substring(i, i + k), hashValue);
                LOGGER.info("\n\tHash Set: {}", hashes);
                LOGGER.info("\n\tResult: {}", result);
            }
        }
        
        return result;
    }
        


    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            String testCase = inputsString.get(i);
            int k = inputsK.get(i);
            // Set<String> result = findRepeatedDnaSequences(testCase, k);
            Set<String> optimizedResult = findRepeatedDnaSequencesOptimized(testCase, k);
            if (LOGGER.isInfoEnabled()) {
                // LOGGER.info("\nTest case: {} with k = {} result: {}", testCase, k, result);
                LOGGER.info("\n\tTest case: {} with k = {} optimized result: {}", testCase, k, optimizedResult);
            }
        }
    }
}
