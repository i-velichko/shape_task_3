package com.epam.thirdtask.observer;

import com.epam.thirdtask.exception.TriangleException;

public interface TriangleObserver {

    void parametersChanged(TriangleEvent triangleEvent) throws TriangleException;

}
