package com.epam.thirdtask.repository;

import com.epam.thirdtask.entity.Triangle;

import java.util.Collection;
import java.util.List;

public interface TriangleRepository {
    boolean add(Triangle triangle);

    boolean addAll(Collection<? extends Triangle> triangles);

    Triangle findById(Long id);

    void update(Triangle triangle, Long id);

    boolean delete(Triangle triangle);

    List<Triangle> query(Specification specification);

}
