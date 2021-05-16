package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.repository.Specification;
import com.epam.thirdtask.repository.TriangleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepositoryImpl implements TriangleRepository {
    private final static TriangleRepositoryImpl instance = new TriangleRepositoryImpl();
    private final static Logger LOGGER = LogManager.getLogger();
    private List<Triangle> triangleList;

    private TriangleRepositoryImpl() {
        triangleList = new ArrayList<>();
    }

    public static TriangleRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public void add(Triangle triangle) {
        triangleList.add(triangle);
        LOGGER.info("New triangle was add to repository " + triangle);
    }

    @Override
    public Triangle findById(Long id) {
        return null;
    }

    @Override
    public void update(Triangle triangle, Long id) {

    }

    @Override
    public boolean delete(Triangle triangle) {
        LOGGER.info("Triangle " + triangle + " was deleted from repository " + triangle);
        return  triangleList.remove(triangle);
    }

    @Override
    public List<Triangle> query(Specification specification) {
        List<Triangle> triangles = triangleList.stream()
                .filter(triangle -> specification.specify(triangle))
                .collect(Collectors.toList());
        return  triangles;
    }

}
