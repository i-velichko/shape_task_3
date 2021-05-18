package com.epam.thirdtask.observer;

import com.epam.thirdtask.exception.TriangleException;

public interface TriangleObservable {

    void addObserver(TriangleObserver observer);

    void removeObserver(TriangleObserver observer);

    void notifyObserver() throws TriangleException;
}
