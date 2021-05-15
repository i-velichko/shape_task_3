package com.epam.thirdtask.service;

import com.epam.thirdtask.entity.Triangle;

public interface TriangleCalculateService {

    double triangleAreaCalculate(Triangle triangle);

    double trianglePerimeterCalculate(Triangle triangle);

}
