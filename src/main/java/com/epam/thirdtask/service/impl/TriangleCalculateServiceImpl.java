package com.epam.thirdtask.service.impl;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.service.TriangleCalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCalculateServiceImpl implements TriangleCalculateService {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public double triangleAreaCalculate(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException("Triangle is null");
        }

        double square;
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        square = Math.abs(((a.getX() - c.getX()) * (b.getY() - c.getY()) -
                (b.getX() - c.getX()) * (a.getY() - c.getY())) * 0.5);

        return square;
    }

    @Override
    public double trianglePerimeterCalculate(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException("Triangle is null");
        }

        double perimeter;
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        double sideAB = Math.hypot(b.getX() - a.getX(), b.getY() - a.getY());
        double sideAC = Math.hypot(c.getX() - a.getX(), c.getY() - a.getY());
        double sideBC = Math.hypot(c.getX() - b.getX(), c.getY() - b.getY());

        perimeter = sideAB + sideAC + sideBC;

        return perimeter;
    }

    @Override
    public double triangleSideCalculate(Point point1, Point point2) throws TriangleException {

        if (point1 == null || point2 == null){
            throw new TriangleException("One or more points is null");
        }
        double x1;
        double y1;
        x1 = point1.getX();
        y1 = point1.getY();

        double x2;
        double y2;
        x2 = point2.getX();
        y2 = point2.getY();

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public double[] triangleSidesCalculate(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException("Triangle is null");
        }
        double[] triangleSides = new double[3];
        triangleSides[0] = triangleSideCalculate(triangle.getPointA(), triangle.getPointB());
        triangleSides[1] = triangleSideCalculate(triangle.getPointB(), triangle.getPointC());
        triangleSides[2] = triangleSideCalculate(triangle.getPointC(), triangle.getPointA());

        return triangleSides;
    }

}
