package com.epam.thirdtask.validator;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidator {
    private final static Logger LOGGER = LogManager.getLogger();

    public boolean isTriangle(Point a, Point b, Point c) throws TriangleException {
        if (a == null || b == null || c == null) {
            throw new TriangleException("One or more points is null, can not create triangle");
        } else {
            LOGGER.info("From points " + a + ", " + b + ", " + c + "  it is possible to build a triangle ");
            return (a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY()) != 0;
        }
    }
}
