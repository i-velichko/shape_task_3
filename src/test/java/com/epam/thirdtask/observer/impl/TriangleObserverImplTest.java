package com.epam.thirdtask.observer.impl;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.entity.TriangleParameters;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.facade.FacadeTriangle;
import com.epam.thirdtask.facade.impl.FacadeTriangleImpl;
import com.epam.thirdtask.filereader.DataFileReader;
import com.epam.thirdtask.observer.TriangleObserver;
import com.epam.thirdtask.parser.DataParser;
import com.epam.thirdtask.repository.TriangleRepository;
import com.epam.thirdtask.repository.impl.TriangleRepositoryImpl;
import com.epam.thirdtask.service.TriangleCalculateService;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;
import com.epam.thirdtask.validator.DataValidator;
import com.epam.thirdtask.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleObserverImplTest {
    private final static String PATH_TO_FILE = "src/test/resources/data/triangleData.txt";
    private final Warehouse warehouse = Warehouse.getInstance();
    private final TriangleRepository repository = TriangleRepositoryImpl.getInstance();
    private TriangleObserver observer;
    private DataFileReader dataFileReader;
    private DataValidator dataValidator;
    private DataParser dataParser;
    private TriangleCalculateService calculateService;

    private FacadeTriangle facadeTriangle;

    @BeforeEach
    void setUp() {
        dataFileReader = new DataFileReader();
        dataValidator = new DataValidator();
        dataParser = new DataParser();
        calculateService = new TriangleCalculateServiceImpl();
        facadeTriangle = new FacadeTriangleImpl(dataFileReader, dataValidator, dataParser, calculateService);
        observer = new TriangleObserverImpl();
    }

    @Test
    void parametersChanged() throws TriangleException {
        facadeTriangle.itIsAMagicWithProject(PATH_TO_FILE);


        Triangle triangle = repository.get(0);
        triangle.addObserver(observer);
        triangle.setPointA(new Point(2.0, 2.0));
        TriangleParameters actualParameters = warehouse.getParameters(1L);
        TriangleParameters expectedParameters = new TriangleParameters(10.06449510224598, 1d);
        Assertions.assertEquals(expectedParameters, actualParameters);

    }
}