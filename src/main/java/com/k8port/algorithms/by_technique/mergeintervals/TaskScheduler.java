package com.k8port.algorithms.by_technique.mergeintervals;

/**
 * Given a char array representing tasks and an integer n, return minimum number 
 * of CPU intervals required to complete all tasks.
 * 
 * @constraint: only one task can be executed during a CPU interval
 * @param tasks char array representing tasks
 * @param n integer representing the cooldown period between identical tasks
 * @return minimum number of CPU intervals required to complete all tasks
 */
public class TaskScheduler {

    private TaskScheduler() {}
    private static class TaskFrequency {
        private int maxFrequency;
        private int maxFrequencyCount;
        private final int[] frequencies;

        public TaskFrequency() {
            this.maxFrequency = 0;
            this.maxFrequencyCount = 0;
            this.frequencies = new int[26];
        }

        /**
         * Adds a task to the task frequency map.
         * @param task char representing the task
         */
        public void addTask(char task) {
            int index = task - 'A';
            frequencies[index]++;
            
            if (frequencies[index] > maxFrequency) {
                maxFrequency = frequencies[index];
                maxFrequencyCount = 1;
            } else if (frequencies[index] == maxFrequency) {
                maxFrequencyCount++;
            }
        }

        /**
         * Returns the maximum frequency of tasks.
         * @return int representing the maximum frequency of tasks
         */
        public int getMaxFrequency() {
            return maxFrequency;
        }

        /**
         * Returns the number of tasks with the maximum frequency.
         * @return int representing the number of tasks with the maximum frequency
         */
        public int getMaxFrequencyCount() {
            return maxFrequencyCount;
        }
    }

    /**
     * Returns the minimum number of CPU intervals required to complete all tasks.
     * @param tasks char array representing tasks
     * @param n integer representing the cooldown period between identical tasks
     * @return int representing the minimum number of CPU intervals required to complete all tasks
     */
    public static int leastIntervals(char[] tasks, int n) {
        TaskFrequency taskFreq = new TaskFrequency();
       
        // Calculate the frequency of each task
        for (char task : tasks) {
            taskFreq.addTask(task);
        }
        
        // Calculate minimum intervals required
        // Formula: max(tasks.length, (maxCount - 1) * (n + 1) + maxCountTasks)
        return Math.max(tasks.length, 
            (taskFreq.getMaxFrequency() - 1) * (n + 1) + taskFreq.getMaxFrequencyCount());
    }
}