package com.epam.thirdtask.warehouse;

import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;

import java.util.HashMap;

public class Warehouse {
    private static Warehouse instance;
    private HashMap<Long, TriangleParameters> storageMap = new HashMap<>();

    private Warehouse() {

    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long id, double area, double perimeter) {
        TriangleParameters parameters = new TriangleParameters();
        parameters.setArea(area);
        parameters.setPerimeter(perimeter);
        instance.storageMap.put(id, parameters);
    }

    public TriangleParameters getParameters(long id) throws TriangleException {
        TriangleParameters parameters = instance.storageMap.get(id);
        if (parameters == null) {
            throw new TriangleException("This item does not exist in warehouse");
        }
        return new TriangleParameters(parameters);
    }

    public void updateParameters(long id, double area, double perimeter) throws TriangleException {
        TriangleParameters parameters = storageMap.get(id);
        if (parameters == null) {
            throw new TriangleException("This item does not exist in warehouse");
        }
        parameters.setArea(area);
        parameters.setPerimeter(perimeter);
    }

    public void removeParameters(long id) throws TriangleException {
        TriangleParameters parameters = storageMap.get(id);
        if (parameters == null) {
            throw new TriangleException("This item does not exist in warehouse");
        }
        storageMap.remove(id);
    }
}

