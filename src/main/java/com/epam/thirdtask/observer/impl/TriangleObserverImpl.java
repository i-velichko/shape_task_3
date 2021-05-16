package com.epam.thirdtask.observer.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.observer.TriangleEvent;
import com.epam.thirdtask.observer.TriangleObserver;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;
import com.epam.thirdtask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserverImpl implements TriangleObserver {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void parametersChanged(TriangleEvent triangleEvent) throws TriangleException {
        Triangle triangle = triangleEvent.getSource();
        TriangleCalculateServiceImpl calculateService = new TriangleCalculateServiceImpl();
        Warehouse warehouse = Warehouse.getInstance();
        long triangleId = triangle.getTriangleId();
        double area = calculateService.triangleAreaCalculate(triangle);
        double perimeter = calculateService.trianglePerimeterCalculate(triangle);
        warehouse.putParameters(triangleId, area, perimeter);
        LOGGER.info("Parameters in warehouse was update with " + triangle);
    }
}
