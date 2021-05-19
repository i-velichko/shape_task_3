package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.repository.Specification;
import com.epam.thirdtask.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification implements Specification {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Warehouse warehouse = Warehouse.getInstance();
    private final double minArea;
    private final double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        Long triangleId = triangle.getId();
        TriangleParameters triangleParameters = null;
        try {
            triangleParameters = warehouse.getParameters(triangleId);
        } catch (TriangleException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }
        double area = 0;
        if (triangleParameters != null) {
            area = triangleParameters.getArea();
        }
        return (area >= minArea && area <= maxArea);
    }
}
