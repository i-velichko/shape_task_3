package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.repository.Specification;

public class AreaSpecification implements Specification {
    private double area;

    public AreaSpecification(double area) {
        this.area = area;
    }

    @Override
    public boolean specify(Triangle triangle) {
        Long triangleId = triangle.getTriangleId();
        //Из вархауса по этому айди тяну вычисления этого треугольника

        //взять из обьекта площаь triangleParameters.getArea();

        //return triangleParameters.getArea().equals(area);
        return true;
    }
}
