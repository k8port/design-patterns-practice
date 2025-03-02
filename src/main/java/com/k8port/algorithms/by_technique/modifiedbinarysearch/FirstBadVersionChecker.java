package com.k8port.algorithms.by_technique.modifiedbinarysearch;

public class FirstBadVersionChecker implements VersionChecker {
    private final int badVersion;
    private int numberOfCalls;

    public FirstBadVersionChecker(int badVersion) {
        this.badVersion = badVersion;
        this.numberOfCalls = 0;
    }

    @Override
    public boolean isBadVersion(int version) {
        numberOfCalls++;
        return version >= badVersion;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void resetNumberOfCalls() {
        numberOfCalls = 0;
    }
}
