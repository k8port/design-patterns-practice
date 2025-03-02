package com.k8port.algorithms.by_technique.mergeintervals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TaskSchedulerTest {
    
    @Test
    void testLeastIntervalsWithTwoIdenticalTasksAndCooldownOfSameLength() {
        char[] tasks = {'A', 'A', 'B', 'B'};
        int n = 2;
        int expected = 5;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }
    
    @Test
    void testLeastIntervalsWithThreeIdenticalTasksAndShorterCooldown() {
        char[] tasks = {'A','A','A','B','B','C','C'};
        int n = 1;
        int expected = 7;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void testLeastIntervalsWithNoCooldownAndDifferentTasks() {
        char[] tasks = {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'};
        int n = 0;
        int expected = 8;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void testLeastIntervalsWithNoCooldownAndIdenticalTasks() {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A'};
        int n = 0;
        int expected = 6;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void testLeastIntervalsWithNoCooldownAndIdenticalTasksWithDifferentFrequency() {
        char[] tasks = {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'};
        int n = 3;
        int expected = 15;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void testLeastIntervalsWithLongerCooldown() {
        char[] tasks = {'A', 'B', 'C', 'O', 'Q', 'C', 'Z', 'O', 'X', 'C', 'W', 'Q', 'Z', 'B', 'M', 'N', 'R', 'L', 'C', 'J'};
        int n = 10;
        int expected = 34;
        int result = TaskScheduler.leastIntervals(tasks, n);
        assertEquals(expected, result);
    }
}
