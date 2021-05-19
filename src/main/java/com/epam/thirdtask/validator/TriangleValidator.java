package com.epam.thirdtask.validator;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.service.TriangleCalculateService;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final TriangleCalculateService triangleCalculateService = new TriangleCalculateServiceImpl();

    public static boolean isTriangle(Triangle triangle) throws TriangleException {
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        if (a == null || b == null || c == null) {
            throw new TriangleException("One or more points is null, can not create triangle");
        } else {
            LOGGER.info("From points " + a + ", " + b + ", " + c + "  it is possible to build a triangle ");
            return (a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY()) != 0;
        }
    }

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

    public boolean isIsoscelesTriangle(Triangle triangle) {
        double[] triangleSides = triangleCalculateService.triangleSidesCalculate(triangle);
        return triangleSides[0] == triangleSides[1] ||
                triangleSides[1] == triangleSides[2] ||
                triangleSides[2] == triangleSides[0];
    }

    public boolean isEquilateralTriangle(Triangle triangle) {
        double[] triangleSides = triangleCalculateService.triangleSidesCalculate(triangle);
        return triangleSides[0] == triangleSides[1] && triangleSides[1] == triangleSides[2];
    }

}
