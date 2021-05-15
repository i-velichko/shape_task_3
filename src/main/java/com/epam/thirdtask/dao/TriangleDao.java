package com.epam.thirdtask.dao;

import com.epam.thirdtask.entity.Triangle;

public interface TriangleDao {
    void add(Triangle triangle);

    Triangle findById(Integer id);

    void update(Triangle triangle);

    boolean delete(Integer id);
}
