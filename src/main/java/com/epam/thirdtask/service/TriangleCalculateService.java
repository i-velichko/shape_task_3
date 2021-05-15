package com.epam.thirdtask.service;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;

public interface TriangleCalculateService {

    double triangleAreaCalculate(Triangle triangle) throws TriangleException;

    double trianglePerimeterCalculate(Triangle triangle) throws TriangleException;

}
