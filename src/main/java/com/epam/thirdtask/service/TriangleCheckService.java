package com.epam.thirdtask.service;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;

public interface TriangleCheckService {

    boolean isRightTriangle(Triangle triangle) throws TriangleException;

    boolean isIsoscelesTriangle(Triangle triangle) throws TriangleException;

    boolean isEquilateralTriangle(Triangle triangle) throws TriangleException;

    boolean isAcuteAngledTriangle(Triangle triangle);

    boolean isObtuseTriangle(Triangle triangle);
}
