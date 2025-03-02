package com.k8port.algorithms.by_datastructure.heaps.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        
        // initialize heap and push first interval of each employee
      
        // iterate for all employee schedules 
        // add start of each schedule's first interval and its index value and value 0
        // set previous interval as start time of first interval

        // repeatedly pop smallest interval from heap and compare with previous interval

        // if current interval start is greater than previous interval end, add free interval

        // update previous interval as max of previous end and current end
        
        // push additional intervals of 1st employee if exists

        // when heap is empty, return free intervals

        return new ArrayList<>();
    }
}
