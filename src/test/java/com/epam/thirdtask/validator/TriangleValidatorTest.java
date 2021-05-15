package com.epam.thirdtask.validator;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleValidatorTest {
    private TriangleValidator triangleValidator;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    @BeforeEach
    void setUp() {
        triangleValidator = new TriangleValidator();
        pointA = new Point(1.0, 0.0);
        pointB = new Point(6.0, 0.0);
        pointC = new Point(3.0, 6.0);
    }

    @Test
    void isTriangle() throws TriangleException {
        Assertions.assertTrue(triangleValidator.isTriangle(pointA, pointB, pointC));
    }

    @Test
    void isNotTriangle() throws TriangleException {
        pointC = new Point(3.0,0.0);
        Assertions.assertFalse(triangleValidator.isTriangle(pointA, pointB, pointC));
    }

    @Test
    void expectedTriangleExceptionWhenPointNull(){
        pointA = null;
        Assertions.assertThrows(TriangleException.class, () ->
                triangleValidator.isTriangle(pointA, pointB, pointC));
    }
}