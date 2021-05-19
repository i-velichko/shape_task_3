package com.epam.thirdtask.warehouse;

import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Long, TriangleParameters> storageMap;

    private Warehouse() {
        storageMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(Long id, Double area, Double perimeter) {
        TriangleParameters parameters = new TriangleParameters();
        parameters.setArea(area);
        parameters.setPerimeter(perimeter);
        instance.storageMap.put(id, parameters);
    }

    public TriangleParameters getParameters(Long id) throws TriangleException {
        TriangleParameters parameters = instance.storageMap.get(id);
        if (parameters == null) {
            throw new TriangleException("This item does not exist in warehouse");
        }
        return new TriangleParameters(parameters);
    }

    public void removeParameters(Long id) throws TriangleException {
        TriangleParameters parameters = storageMap.get(id);
        if (parameters == null) {
            throw new TriangleException("This item does not exist in warehouse");
        }
        storageMap.remove(id);
    }
}

