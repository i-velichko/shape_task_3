package com.epam.thirdtask.service;

import com.epam.thirdtask.entity.Triangle;

public interface TriangleCheckService {

    boolean isRectangularTriangle(Triangle triangle);

    boolean isIsoscelesTriangle(Triangle triangle);

    boolean isEquilateralTriangle(Triangle triangle);

    boolean isAcuteAngledTriangle(Triangle triangle);

    boolean isObtuseTriangle(Triangle triangle);
}
