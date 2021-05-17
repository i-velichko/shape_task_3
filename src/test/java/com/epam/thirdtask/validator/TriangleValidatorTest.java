package com.epam.thirdtask.validator;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleValidatorTest {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Triangle wrightTriangle;

    @BeforeEach
    void setUp() {
        pointA = new Point(1.0, 0.0);
        pointB = new Point(6.0, 0.0);
        pointC = new Point(3.0, 6.0);
        pointD = new Point(3.0, 0.0);
        wrightTriangle = new Triangle(pointA, pointB, pointC);

    }

    @Test
    void isTriangle() throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangle(wrightTriangle));
    }

    @Test
    void isNotTriangle() throws TriangleException {
        Assertions.assertFalse(TriangleValidator.isTriangle(new Triangle(pointA, pointB, pointD)));
    }

    @Test
    void expectedTriangleExceptionWhenPointNull() {
        Assertions.assertThrows(TriangleException.class, () ->
                TriangleValidator.isTriangle(new Triangle(null, pointB, pointC)));
    }
}