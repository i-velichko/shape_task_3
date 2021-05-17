package com.epam.thirdtask.facade.impl;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.facade.FacadeTriangle;
import com.epam.thirdtask.factory.TriangleFactory;
import com.epam.thirdtask.filereader.DataFileReader;
import com.epam.thirdtask.parser.DataParser;
import com.epam.thirdtask.repository.impl.TriangleRepositoryImpl;
import com.epam.thirdtask.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class FacadeTriangleImpl implements FacadeTriangle {
    private final DataFileReader dataFileReader;
    private final DataValidator dataValidator;
    private final DataParser dataParser;

    public FacadeTriangleImpl(DataFileReader dataFileReader, DataValidator dataValidator, DataParser dataParser) {
        this.dataFileReader = dataFileReader;
        this.dataValidator = dataValidator;
        this.dataParser = dataParser;
    }

    @Override
    public boolean createTrianglesList(String pathToFile) throws TriangleException {
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
                e.printStackTrace();
            }
        }

        TriangleRepositoryImpl repository = TriangleRepositoryImpl.getInstance();
        return repository.addAll(triangles);
    }
}
