package com.k8port.algorithms.by_technique.heaps;

public class InvestmentProject {
   
    private final int capital;
    private final int profit;

    public InvestmentProject(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }

    public int getCapital() {
        return capital;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "InvestmentProject{" +
                "capital=" + capital +
                ", profit=" + profit +
                '}';
    }
}
