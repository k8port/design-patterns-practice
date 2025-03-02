package com.k8port.algorithms.by_datastructure.heaps.mergeintervals;

public class Interval {
    int start;
    int end;
    boolean closed;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }

    public boolean isClosed() {
        return closed;
    }
}