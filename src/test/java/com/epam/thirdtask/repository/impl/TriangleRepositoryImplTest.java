package com.epam.thirdtask.repository.impl;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class TriangleRepositoryImplTest {

    private Triangle triangle1;
    private Triangle triangle2;
    private Triangle triangle3;
    private List<Triangle> triangleList;

    @Mock
    private Warehouse warehouse;
    @InjectMocks
    private TriangleRepositoryImpl repository;

    @BeforeEach
    public void setUp() throws TriangleException {
        MockitoAnnotations.openMocks(this);
        repository = TriangleRepositoryImpl.getInstance();
        triangle1 = new Triangle(new Point(1.0, 0.0), new Point(6.0, 0.0), new Point(3.0, 6.0));
        triangle2 = new Triangle(new Point(1.0, 2.0), new Point(-5.0, -2.0), new Point(-9.0, 4.0));
        triangle3 = new Triangle(new Point(0.0, 0.0), new Point(3.0, 4.0), new Point(10.0, -6.0));

        when(warehouse.getParameters(eq(1L))).thenReturn(new TriangleParameters(20.0, 60.0));
        when(warehouse.getParameters(eq(2L))).thenReturn(new TriangleParameters(30.0, 90.0));
        when(warehouse.getParameters(eq(3L))).thenReturn(new TriangleParameters(5.0, 15.0));

        triangleList = new ArrayList<>();
        triangleList.add(triangle1);
        triangleList.add(triangle2);
        triangleList.add(triangle3);
        repository.addAll(triangleList);
    }

    @Test
    public void testIsSuccessfulQuery() {
        List<Triangle> query = repository.query(new PerimeterSpecification(warehouse, 5.0, 20.0));
        int actualSize = query.size();
        int expectedSize = 2;
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addAllIsCompleteSuccessful() {
        Assertions.assertTrue(repository.addAll(triangleList));
    }

    @Test
    public void addIsCompleteSuccessful() {
        Assertions.assertTrue(repository.add(triangle1));
    }

    @Test
    public void deleteIsCompleteSuccessful() {
        Assertions.assertTrue(repository.delete(triangle1));
    }
}