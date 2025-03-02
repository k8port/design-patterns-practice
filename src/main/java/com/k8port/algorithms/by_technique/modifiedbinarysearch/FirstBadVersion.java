package com.k8port.algorithms.by_technique.modifiedbinarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Latest version of software has failed quality check. Each version builds on previous version
 * which is why all versions after a bad version are also considered bad.
 * Given `n` versions representing integers 1 through `n` and an API function `isBadVersion(version)`
 * which returns true if a given version is bad, find first bad version causing subsequent versions
 * to fail while minimizing calls to `isBadVersion(version)` function.
 * 
 * @param n number of versions
 * @return first bad version
 */

public class FirstBadVersion {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstBadVersion.class);
    private FirstBadVersion() {}

    public static int firstBadVersion(int n, VersionChecker checker) {
        int start = 1;
        int last = n;
        int mid = (start + last) / 2;
        int numberOfCalls = 0;
        while (start <= last) {
            LOGGER.info("Checking version: {}", mid);
            if (checker.isBadVersion(mid)) {
                LOGGER.info("Version {} is bad", mid);
                last = mid - 1;
                numberOfCalls++;
            } else {
                LOGGER.info("Version {} is good", mid);
                start = mid + 1;
                numberOfCalls++;
            }
            mid = (start + last) / 2;
            LOGGER.info("New mid: {}", mid);
            LOGGER.info("Number of calls so far: {}", numberOfCalls);
        }
        LOGGER.info("First bad version: {}", start);
        LOGGER.info("Number of calls: {}", numberOfCalls);
        return start;
    }
   
    /**
     *
     * run:
     * 1 {*2} 3 4
     *
     * start=1, last=4, mid=2
     * checker.isBadVersion(2) -> true
     * start=1, last=1, mid=1
     * checker.isBadVersion(1) -> false
     * requires 2 calls to API
     * 
     
     * @param args
     */
    public static void main(String[] args) {
        String blocker = "-----------------------------------------";
        FirstBadVersionChecker checker = new FirstBadVersionChecker(2);
        int version = FirstBadVersion.firstBadVersion(3, checker);
        System.out.println("Expecting 1 call to API to find bad version (2)");
        System.out.printf("Found version: %d, using %d api calls\n", version, checker.getNumberOfCalls());
        System.out.println(blocker);

        FirstBadVersionChecker checker2 = new FirstBadVersionChecker(1);
        version = FirstBadVersion.firstBadVersion(7, checker2);
        System.out.println("Expecting 3 calls to API to find bad version (1)");
        System.out.printf("Found version: %d, using %d api calls\n", version, checker2.getNumberOfCalls());
        System.out.println(blocker);

        FirstBadVersionChecker checker3 = new FirstBadVersionChecker(4);
        version = FirstBadVersion.firstBadVersion(10, checker3);
        System.out.println("Expecting 4 calls to API to find bad version (4)");
        System.out.printf("Found version: %d, using %d api calls\n", version, checker3.getNumberOfCalls());
        System.out.println(blocker);

        FirstBadVersionChecker checker4 = new FirstBadVersionChecker(9);
        version = FirstBadVersion.firstBadVersion(9, checker4);
        System.out.println("Expecting 4 calls to API to find bad version (9)");
        System.out.printf("Found version: %d, using %d api calls\n", version, checker4.getNumberOfCalls());
        System.out.println(blocker);

        FirstBadVersionChecker checker5 = new FirstBadVersionChecker(2);
        version = FirstBadVersion.firstBadVersion(4, checker5);
        System.out.println("Expecting 2 calls to API to find bad version (2)");
        System.out.printf("Found version: %d, using %d api calls\n", version, checker5.getNumberOfCalls());
        System.out.println(blocker);
    }
}