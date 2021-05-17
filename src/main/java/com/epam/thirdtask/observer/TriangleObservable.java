package com.epam.thirdtask.observer;

import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.observer.impl.TriangleObserverImpl;

public interface TriangleObservable {

    void addObserver(TriangleObserver observer);

    void removeObserver(TriangleObserver observer);

    void notifyObserver() throws TriangleException;
}
