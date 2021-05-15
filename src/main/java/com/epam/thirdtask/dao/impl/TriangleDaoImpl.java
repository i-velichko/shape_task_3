package com.epam.thirdtask.dao.impl;

import com.epam.thirdtask.dao.TriangleDao;
import com.epam.thirdtask.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleDaoImpl implements TriangleDao {
    private static List<Triangle> triangleList = new ArrayList<>();

    @Override
    public void add(Triangle triangle) { //сохраняет в мапу выше

    }

    @Override
    public Triangle findById(Integer id) {
        return null;
    }

    @Override
    public void update(Triangle triangle) { //maybe need ID to second param

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
