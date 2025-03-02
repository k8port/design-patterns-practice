package com.k8port.algorithms.by_datastructure.arrays;

/**
 * Abstract base class to define core structures of 2 pointers algorithm. 
 * Can be extended to solve various problems like:
 * - Finding pairs with specific sum
 * - Detecting palindromes
 * - Validating parentheses
 * - Removing duplicates from sorted array
 * - Merging two sorted arrays
 * - Rotating an array
 * - And more...
 * @param <T> Type of elements in the array
 * @param <R> Type of result to be returned
 */
public abstract class TwoPointersAlgorithm<T, R> {
    protected int leftPointer;
    protected int rightPointer;

    /**
     * Template method defining skeleton of 2 pointers algorithm.
     * Concrete implementations will define the logic of how to move the pointers.
     * @return Result of the algorithm
     */
    public R execute(T input) {
        // init pointers based on requirements of problem
        initializePointers(input);

        // process input until termination condition is met
        while (!isTerminationConditionMet()) {
            // check if pointer positions satisfy condition for problem
            if (isSuccessConditionMet()) {
                // process elements at pointer positions
                processSuccessCase();
            } else {
                // move pointers based on problem-specific logic
                movePointers();
            }
        }

        return getResult();
    }

   /** 
    *  Initialize pointer positions.
    *  Different problems require different initial positions for pointers.
    */ 
    protected abstract void initializePointers(T input);

    /**
     * Determine when termination condition is met.
     * 
     */
    protected abstract boolean isTerminationConditionMet();

    /**
     * Check if target condition is met.
     * @return True if target condition is met, false otherwise
     */
    protected abstract boolean isSuccessConditionMet();

    /**
     * Process elements at pointer positions when target condition is met.
     */
    protected abstract void processSuccessCase();

    /**
     * Move pointers based on problem-specific logic.
     */
    protected abstract void movePointers();

    /**
     * Get result of the algorithm.
     * @return Result of the algorithm
     */
    protected abstract R getResult();

}
