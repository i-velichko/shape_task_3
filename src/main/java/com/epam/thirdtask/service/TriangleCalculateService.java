package com.epam.thirdtask.service;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;

public interface TriangleCalculateService {

    double triangleAreaCalculate(Triangle triangle) throws TriangleException;

    double trianglePerimeterCalculate(Triangle triangle) throws TriangleException;

    double triangleSideCalculate(Point p1, Point p2) throws TriangleException;

    double [] triangleSidesCalculate(Triangle triangle) throws TriangleException;

}
