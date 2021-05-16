package com.epam.thirdtask.service.impl;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.service.TriangleCheckService;
import com.epam.thirdtask.validator.TriangleValidator;

public class TriangleCheckServiceImpl implements TriangleCheckService {

    @Override
    public boolean isRightTriangle(Triangle triangle) throws TriangleException {
        if (!TriangleValidator.isTriangle(triangle)) {
            throw new TriangleException("It isn't triangle");
        }

        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        double edgeSqAB = Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2);
        double edgeSqAC = Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2);
        double edgeSqBC = Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2);

        return edgeSqAB + edgeSqAC == edgeSqBC || edgeSqAC + edgeSqBC == edgeSqAB || edgeSqBC + edgeSqAB == edgeSqAC;

    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) throws TriangleException {
        if (!TriangleValidator.isTriangle(triangle)) {
            throw new TriangleException("It isn't triangle");
        }
        TriangleCalculateServiceImpl triangleCalculateService = new TriangleCalculateServiceImpl();
        boolean result = false;
        double[] triangleSides = triangleCalculateService.triangleSidesCalculate(triangle);
        if (triangleSides[0] == triangleSides[1] ||
                triangleSides[1] == triangleSides[2] ||
                triangleSides[2] == triangleSides[0]) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean isEquilateralTriangle(Triangle triangle) throws TriangleException {
        if (!TriangleValidator.isTriangle(triangle)) {
            throw new TriangleException("It isn't triangle");
        }

        TriangleCalculateServiceImpl triangleCalculateService = new TriangleCalculateServiceImpl();
        boolean result = false;
        double[] triangleSides = triangleCalculateService.triangleSidesCalculate(triangle);

        if (triangleSides[0] == triangleSides[1] && triangleSides[1] == triangleSides[2]) {
            result = true;
        }

        return result;

    }

    @Override
    public boolean isAcuteAngledTriangle(Triangle triangle) {
        return false;
    }

    @Override
    public boolean isObtuseTriangle(Triangle triangle) {
        return false;
    }
}
