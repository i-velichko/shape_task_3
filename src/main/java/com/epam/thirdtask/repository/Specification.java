package com.epam.thirdtask.repository;

import com.epam.thirdtask.entity.Triangle;

@FunctionalInterface
public interface Specification {

    boolean specify(Triangle triangle);
}
