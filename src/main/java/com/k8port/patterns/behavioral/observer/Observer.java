package com.k8port.patterns.behavioral.observer;

public interface Observer<T> {
    void update(T data);
}
