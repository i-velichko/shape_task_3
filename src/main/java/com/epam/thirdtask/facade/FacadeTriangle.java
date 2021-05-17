package com.epam.thirdtask.facade;

import com.epam.thirdtask.exception.TriangleException;

public interface FacadeTriangle {

    boolean createTrianglesList(String pathToFile) throws TriangleException;
}
