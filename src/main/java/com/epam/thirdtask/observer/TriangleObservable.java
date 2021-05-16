package com.epam.thirdtask.observer;

public interface TriangleObservable {

    void attachObserver(TriangleObserver observer);

    void detachObserver();

    void notifyObservers();
}
