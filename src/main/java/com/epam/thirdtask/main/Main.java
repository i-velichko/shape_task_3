package com.epam.thirdtask.main;

import com.epam.thirdtask.entity.Point;
import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.facade.FacadeTriangle;
import com.epam.thirdtask.facade.impl.FacadeTriangleImpl;
import com.epam.thirdtask.filereader.DataFileReader;
import com.epam.thirdtask.observer.TriangleObserver;
import com.epam.thirdtask.observer.impl.TriangleObserverImpl;
import com.epam.thirdtask.parser.DataParser;
import com.epam.thirdtask.repository.TriangleRepository;
import com.epam.thirdtask.repository.impl.TriangleRepositoryImpl;
import com.epam.thirdtask.service.TriangleCalculateService;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;
import com.epam.thirdtask.validator.DataValidator;

public class Main {
    private final static String PATH_TO_FILE = "src/main/resources/data/triangleData.txt";

    public static void main(String[] args) throws TriangleException {
        DataFileReader reader = new DataFileReader();
        DataValidator validator = new DataValidator();
        DataParser parser = new DataParser();
        TriangleRepository repository = TriangleRepositoryImpl.getInstance();
        TriangleCalculateService calculateService = new TriangleCalculateServiceImpl();
        TriangleObserver observer = new TriangleObserverImpl();

        FacadeTriangle facadeTriangle = new FacadeTriangleImpl(reader, validator, parser, calculateService);
        facadeTriangle.itIsAMagicWithProject(PATH_TO_FILE);

        Triangle triangle = repository.get(0);
        triangle.addObserver(observer);
        triangle.setPointA(new Point(2.0, 2.0));

    }
}
