package com.epam.thirdtask.factory;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleFactory {
    private final static Logger LOGGER = LogManager.getLogger();

    public static Triangle createTriangle(Point a, Point b, Point c) {
        return new Triangle(a, b, c);
    }

    public static Triangle createTriangle(double[] coordinates) throws TriangleException {

        if (coordinates.length == 6) {
            Point pointA = new Point(coordinates[0], coordinates[1]);
            Point pointB = new Point(coordinates[2], coordinates[3]);
            Point pointC = new Point(coordinates[4], coordinates[5]);
            LOGGER.info("Create triangle from data (" + pointA + ", " + pointB + ", " + pointC + ") successful.");
            return createTriangle(pointA, pointB, pointC);
        }
        throw new TriangleException("Unable to create triangle from this coordinates " + Arrays.toString(coordinates));
    }
}
