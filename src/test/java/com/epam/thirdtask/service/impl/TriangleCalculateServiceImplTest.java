package com.epam.thirdtask.service.impl;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleCalculateServiceImplTest {
    private final static Point A = new Point(1.0, 0.0);
    private final static Point B = new Point(6.0, 0.0);
    private final static Point C = new Point(3.0, 6.0);
    private TriangleCalculateServiceImpl triangleCalculateService;
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangleCalculateService = new TriangleCalculateServiceImpl();
        triangle = new Triangle(A, B, C);
    }

    @Test
    void triangleAreaCalculate() throws TriangleException {
        double expectedTriangleArea = 15.0;
        double actualTriangleArea = triangleCalculateService.triangleAreaCalculate(triangle);
        Assertions.assertEquals(expectedTriangleArea, actualTriangleArea);
    }

    @Test
    void expectedExceptionInAreaCalculateWhenTriangleIsNull() throws TriangleException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NullPointerException.class, () -> {
            triangleCalculateService.triangleAreaCalculate(triangle);
        });
    }

    @Test
    void trianglePerimeterCalculate() throws TriangleException {
        double expectedTrianglePerimeter = 18.03275925283613;
        double actualTrianglePerimeter = triangleCalculateService.trianglePerimeterCalculate(triangle);
        Assertions.assertEquals(expectedTrianglePerimeter, actualTrianglePerimeter);
    }

    @Test
    void expectedExceptionInPerimeterCalculateWhenTriangleIsNull() throws TriangleException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NullPointerException.class, () -> {
            triangleCalculateService.triangleAreaCalculate(triangle);
        });
    }
}