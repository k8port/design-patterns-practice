package com.k8port.algorithms.by_datastructure.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and integer k, return length of longest
 * substring containing identical character after replacing
 * at most k characters with any other character.
 *
 * @param s - string containing characters, e.g., "aabccbb"
 * @parm k - maximum number of replacements allowed, e.g., 2
 * @return length of longest substring after replacing no more than k characters, e.g., 5 
 * replacing 2 instances of 'c' with 'b' to get "bbbbb" as longest substring ("bccbb") 
 * of s ("aabccbb")
 */
public class LongestRepeatingCharacterReplacement {

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        // maintain hashmap to store frequency of characters in current window
        Map<Character, Integer> charFrequency = new HashMap<>();

        // iterate over input string using sliding window technique
        // maintain a variable to store length of longest substring containing identical character
        int longestValidWindow = 0;  // length of longest substring containing identical character so far
        int windowStart = 0; // start of current window
        int maxFrequency = 0; // max frequency of any character in current window

        for (int i = 0; i < s.length(); i++) {
            int windowEnd = i;
            char current = s.charAt(i);
            charFrequency.put(current, charFrequency.getOrDefault(current, 0) + 1);
            maxFrequency = Math.max(maxFrequency, charFrequency.get(current));

            // if number of chars to change is greater than k, slide window one character right
            if (windowEnd - windowStart + 1 - maxFrequency > k) {
                char left = s.charAt(windowStart);
                charFrequency.put(left, charFrequency.get(left) - 1);
                windowStart++;
            }

            // if current window contains identical characters and is longest substring so far
            longestValidWindow = Math.max(longestValidWindow, windowEnd - windowStart + 1);
        }

        return longestValidWindow;
    }

    public static void main(String[] args) {
        String[] test_cases = {"aaacbbbaabab", "aaacbbbaabab", "dippitydip", "coollooc", "aaaaaaaaaa"};
        int [] test_k = {2, 1, 4, 2, 2, 2};

        for (int i = 0; i < test_cases.length; i++) {
            System.out.println(String.format("Test case %d: %s with at most %d replacements = substring of length %d", (i + 1), test_cases[i], test_k[i], longestRepeatingCharacterReplacement(test_cases[i], test_k[i])));
        }
        
        
    }
}
