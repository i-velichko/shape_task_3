package com.epam.thirdtask.repository;

import com.epam.thirdtask.entity.Triangle;

import java.util.List;

public interface TriangleRepository {
    void add(Triangle triangle);

    Triangle findById(Long id);

    void update(Triangle triangle, Long id);

    boolean delete(Triangle triangle);

    List<Triangle> query(Specification specification);

}
