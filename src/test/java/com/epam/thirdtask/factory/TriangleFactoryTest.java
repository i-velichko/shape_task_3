package com.epam.thirdtask.factory;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleFactoryTest {
    private TriangleFactory triangleFactory;
    Point a;
    Point b;
    Point c;
    private final static double[] UNCORRECTED_TRIANGLE_COORDINATES_ARRAY = new double[5];

    @BeforeEach
    void setUp() {
        triangleFactory = new TriangleFactory();
        a = new Point();
        b = new Point();
        c = new Point();
    }

    @Test
    void createTriangle() {
        Assertions.assertInstanceOf(Triangle.class, TriangleFactory.createTriangle(a, b, c));
    }

    @Test
    void expectedTriangleExceptionsWhenUncorrectedArray() {
        Assertions.assertThrows(TriangleException.class, () ->
                TriangleFactory.createTriangle(UNCORRECTED_TRIANGLE_COORDINATES_ARRAY));
    }
}