package com.k8port.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    public void attachObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void detachObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T data) {
        for (Observer<T> observer : observers) {
            observer.update(data);
        }
    }
}

