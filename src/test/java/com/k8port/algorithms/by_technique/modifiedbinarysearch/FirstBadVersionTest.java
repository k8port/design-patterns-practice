package com.k8port.algorithms.by_technique.modifiedbinarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstBadVersionTest {

    private FirstBadVersionChecker checker;

    @ParameterizedTest
    @CsvSource({
        "3, 2, 2, 2",
        "5, 4, 4, 2",
        "10, 7, 7, 3",
        "10, 10, 10, 1",
        "10, 1, 1, 1"
    })
    void testFirstBadVersion(int n, int badVersion, int expectedVersion, int expectedNumberOfCalls) {
        checker = new FirstBadVersionChecker(badVersion);
        int result = FirstBadVersion.firstBadVersion(n, checker);
        assertEquals(expectedVersion, result);
        assertEquals(expectedNumberOfCalls, checker.getNumberOfCalls());
    }
}