package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.repository.Specification;

public class IdSpecification implements Specification {
    private Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specify(Triangle triangle) {

        return triangle.getTriangleId().equals(id);
    }
}
