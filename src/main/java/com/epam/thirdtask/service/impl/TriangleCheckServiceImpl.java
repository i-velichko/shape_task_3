package com.epam.thirdtask.service.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.service.TriangleCheckService;

public class TriangleCheckServiceImpl implements TriangleCheckService {

    @Override
    public boolean isRectangularTriangle(Triangle triangle) {
        return false;
    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) {
        return false;
    }

    @Override
    public boolean isEquilateralTriangle(Triangle triangle) {
        return false;
    }

    @Override
    public boolean isAcuteAngledTriangle(Triangle triangle) {
        return false;
    }

    @Override
    public boolean isObtuseTriangle(Triangle triangle) {
        return false;
    }
}
