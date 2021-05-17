package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.repository.Specification;
import com.epam.thirdtask.warehouse.Warehouse;

public class AreaSpecification implements Specification {
    private double minArea;
    private double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        Warehouse warehouse = Warehouse.getInstance();
        Long triangleId = triangle.getTriangleId();
        TriangleParameters triangleParameters = null;
        try {
            triangleParameters = warehouse.getParameters(triangleId);
        } catch (TriangleException e) {
            e.printStackTrace();
        }
        double area = 0;
        if (triangleParameters != null) {
            area = triangleParameters.getArea();
        }
        return (area >= minArea && area <= maxArea);
    }
}
