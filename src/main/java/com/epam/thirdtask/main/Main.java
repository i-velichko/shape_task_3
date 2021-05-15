package com.epam.thirdtask.main;

import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.filereader.DataFileReader;
import com.epam.thirdtask.parser.DataParser;
import com.epam.thirdtask.validator.DataValidator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TriangleException {

        DataFileReader dataFileReader = new DataFileReader();
        DataValidator dataValidator = new DataValidator();
        DataParser dataParser = new DataParser();

        List<String> strings = dataFileReader.readAllDataFromFile("src/main/resources/data/triangleData.txt");
        dataValidator.isStringValid(strings.get(2));
        System.out.println(Arrays.toString(dataParser.parseStringToDouble(strings.get(2))));

    }
}
