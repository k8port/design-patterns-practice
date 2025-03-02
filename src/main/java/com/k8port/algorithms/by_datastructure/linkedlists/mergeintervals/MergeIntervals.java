package com.k8port.algorithms.by_datastructure.linkedlists.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * Given a list of closed intervals, merge overlapping intervals and return new list of non-overlapping intervals.
 *
 * @param intervals List of intervals with start and end times.
 * @return List of merged intervals.
 */
public class MergeIntervals {
    
    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        // create output list and copy first interval into it
        LinkedList<int[]> output = new LinkedList<>();
        output.add(intervals[0]);

        // Iterate through remaining intervals
        // check if any interval overlaps with interval in output list
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastAdded = output.getLast();
            int currentStart = current[0];
            int currentEnd = current[1];
            int prevEnd = lastAdded[1];
            
            if (currentStart <= prevEnd) {
                lastAdded[1] = Math.max(currentEnd, prevEnd);
            } else {
                output.add(current);
            }

            System.out.println(String.format("\n\t\t\tCurrent input interval: [%d, %d]\n", currentStart, currentEnd));
            
            System.out.println("\t\t\t|    curStart   |    curEnd   |");
            System.out.println("\t\t\t ----------------------------- ");
            System.out.println(String.format("\t\t\t|    %-12d|    %-10d|", currentStart, currentEnd));
            System.out.println("\t\t\t ----------------------------- ");

        }

        return output.toArray(new int[][]{});
    }
    

    public static void main(String[] args) {
        int[][][] allIntervals = {
            {{1, 5}, {3, 7}, {4, 6}},
            {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
            {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
            {{1, 5}},
            {{1, 9}, {3, 8}, {4, 4}},
            {{1, 2}, {3, 4}, {8, 8}},
            {{1, 5}, {1, 3}},
            {{1, 5}, {6, 9}},
            {{0, 0}, {1, 18}, {1, 3}}
        };
    
        int i = 0;
        for (int[][] intervals : allIntervals) {
            System.out.println(i+1+ ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = merge(intervals);
            System.out.println(new String(new char[100]).replace('\0', '-')); System.out.println("Merged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i++;
        }
    }
}
