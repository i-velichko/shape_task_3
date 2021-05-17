package com.epam.thirdtask.repository;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;

@FunctionalInterface
public interface Specification {

    boolean specify(Triangle triangle) throws TriangleException;
}
