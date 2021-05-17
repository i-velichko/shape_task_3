package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.repository.Specification;
import com.epam.thirdtask.warehouse.Warehouse;

public class PerimeterSpecification implements Specification {
private double minPerimeter;
private double maxPerimeter;

    public PerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Triangle triangle) throws TriangleException {
        Warehouse warehouse = Warehouse.getInstance();
        Long triangleId = triangle.getTriangleId();
        TriangleParameters triangleParameters = warehouse.getParameters(triangleId);
        double perimeter = triangleParameters.getPerimeter();
        return (perimeter >= minPerimeter && perimeter <= maxPerimeter);
    }
}
