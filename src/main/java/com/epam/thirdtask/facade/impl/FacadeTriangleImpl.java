package com.epam.thirdtask.facade.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.facade.FacadeTriangle;
import com.epam.thirdtask.factory.TriangleFactory;
import com.epam.thirdtask.filereader.DataFileReader;
import com.epam.thirdtask.parser.DataParser;
import com.epam.thirdtask.repository.TriangleRepository;
import com.epam.thirdtask.repository.impl.TriangleRepositoryImpl;
import com.epam.thirdtask.service.TriangleCalculateService;
import com.epam.thirdtask.validator.DataValidator;
import com.epam.thirdtask.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FacadeTriangleImpl implements FacadeTriangle {
    private final static Logger LOGGER = LogManager.getLogger();
    private final DataFileReader dataFileReader;
    private final DataValidator dataValidator;
    private final DataParser dataParser;
    private final TriangleCalculateService calculateService;
    private final TriangleRepository repository = TriangleRepositoryImpl.getInstance();
    private Warehouse warehouse = Warehouse.getInstance();

    public FacadeTriangleImpl(DataFileReader dataFileReader, DataValidator dataValidator, DataParser dataParser, TriangleCalculateService calculateService) {
        this.dataFileReader = dataFileReader;
        this.dataValidator = dataValidator;
        this.dataParser = dataParser;
        this.calculateService = calculateService;
    }

    @Override
    public void itIsAMagicWithProject(String pathToFile) throws TriangleException {
        List<String> dataLines = dataFileReader.readAllDataFromFile(pathToFile);
        List<Triangle> triangles = new ArrayList<>();
        for (String nextLine : dataLines) {
            try {
                if (dataValidator.isStringValid(nextLine)) {
                    double[] pointNumbers = dataParser.parseStringToDouble(nextLine);
                    Triangle triangle = TriangleFactory.createTriangle(pointNumbers);
                    triangles.add(triangle);
                }
            } catch (TriangleException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            }
        }
        repository.addAll(triangles);

        for (Triangle triangle : triangles) {
            double area = calculateService.triangleAreaCalculate(triangle);
            double perimeter = calculateService.trianglePerimeterCalculate(triangle);
            warehouse.putParameters(triangle.getId(), area, perimeter);
        }
    }
}
