package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.repository.Specification;
import com.epam.thirdtask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterSpecification implements Specification {
    private final static Logger LOGGER = LogManager.getLogger();
    private double minPerimeter;
    private double maxPerimeter;
    private Warehouse warehouse;

    public PerimeterSpecification(Warehouse warehouse, double minPerimeter, double maxPerimeter) {
        this.warehouse = warehouse;
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    public PerimeterSpecification() {
    }

    @Override
    public boolean specify(Triangle triangle) {

        Long triangleId = triangle.getId();
        TriangleParameters triangleParameters = null;
        try {
            triangleParameters = warehouse.getParameters(triangleId);
        } catch (TriangleException e) {
            LOGGER.error(e.getMessage());
        }
        double perimeter = 0;
        if (triangleParameters != null) {
            perimeter = triangleParameters.getPerimeter();
        }
        return (perimeter >= minPerimeter && perimeter <= maxPerimeter);
    }
}
