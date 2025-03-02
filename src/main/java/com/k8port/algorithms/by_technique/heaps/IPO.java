package com.k8port.algorithms.by_technique.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/** Craft automated investment strategy to maximize profit from a given set of projects.
 *  Investor's current capital must be >= capital required for all selected projects.
 *  Once a project is selected, profit is realized and added to investor's capital.
 *  Investor can invest according to new total capital.
 *  Each project can only be selected once.
 * 
 * @param c amount of capital invested
 * @param k number of distinct projects that can be selected
 * @param profits array of profits for each project
 * @param capital array of capital required for each project
 * @return maximum profit achievable
 */
public class IPO {
    public int maxCapital(int c, int k, int[] profits, int[] capital) {
        // create min heap to store capitals
        PriorityQueue<InvestmentProject> minHeapCapital = new PriorityQueue<>(Comparator.comparingInt(InvestmentProject::getCapital));
        for (int i = 0; i < capital.length; i++) minHeapCapital.add(new InvestmentProject(capital[i], profits[i]));
        
        // create max heap to store profits
        PriorityQueue<InvestmentProject> maxHeapProfits = new PriorityQueue<>(Comparator.comparingInt(InvestmentProject::getProfit).reversed());
        
        int numProjectsSelected = 0;
        int currentCapital = c;

        while (numProjectsSelected < k) {
            // identify projects that can be selected with range of current capital
            while (!minHeapCapital.isEmpty() && minHeapCapital.peek().getCapital() <= currentCapital) {
                maxHeapProfits.add(minHeapCapital.poll());
            }
            
            if (maxHeapProfits.isEmpty()) break;

            // Select project that yields highest profit
            currentCapital += maxHeapProfits.poll().getProfit();
            numProjectsSelected++;
        }

        return currentCapital;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        IPO ipo = new IPO();
        int initialCapital = 1;
        int projectSelectionLimit = 2;
        int[] capital = {1, 2, 2, 3};
        int[] profits = {2, 4, 6, 8};
        int maxProfit = ipo.maxCapital(initialCapital, projectSelectionLimit, profits, capital);
        System.out.println("Expected max profit: 11");
        System.out.printf("Max profit: %d\n", maxProfit);
        
        initialCapital = 2;
        projectSelectionLimit = 2;
        capital = new int[] {1, 2, 3, 4};
        profits = new int[] {1, 3, 5, 7};
        maxProfit = ipo.maxCapital(initialCapital, projectSelectionLimit, profits, capital);
        System.out.println("Expected max profit: 12");
        System.out.printf("Max profit: %d\n", maxProfit);

        initialCapital = 2;
        projectSelectionLimit = 3;
        capital = new int[] {1, 3, 4, 5, 6};
        profits = new int[] {1, 2, 3, 4, 5};
        maxProfit = ipo.maxCapital(initialCapital, projectSelectionLimit, profits, capital);
        System.out.println("Expected max profit: 9");
        System.out.printf("Max profit: %d\n", maxProfit);

        initialCapital = 1;
        projectSelectionLimit = 3;
        capital = new int[] {0, 1, 2};
        profits = new int[] {1, 2, 3};
        maxProfit = ipo.maxCapital(initialCapital, projectSelectionLimit, profits, capital);
        System.out.println("Expected max profit: 7");
        System.out.printf("Max profit: %d\n", maxProfit);

        initialCapital = 1;
        projectSelectionLimit = 3;
        capital = new int[] {1, 2, 3, 11, 19, 21};
        profits = new int[] {2, 7, 9, 16, 17, 18};
        maxProfit = ipo.maxCapital(initialCapital, projectSelectionLimit, profits, capital);
        System.out.println("Expected max profit: 28");
        System.out.printf("Max profit: %d\n", maxProfit);
    }
}