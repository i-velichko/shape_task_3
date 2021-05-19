package com.epam.thirdtask.filereader;

import com.epam.thirdtask.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFileReader {
    private final static Logger LOGGER = LogManager.getLogger();

    public List<String> readAllDataFromFile(String pathToFile) throws TriangleException {
        List<String> listOfDataForTriangle;

        if (pathToFile == null) {
            throw new TriangleException("File path does not exist.");
        }

        try {
            Stream<String> lineStream = Files.lines(Path.of(pathToFile));
            LOGGER.info("File " + pathToFile + "read successfully.");
            listOfDataForTriangle = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Error in DataFileReader " + e.getMessage());
            throw new TriangleException("Can not open file " + pathToFile);
        }
        return listOfDataForTriangle;
    }
}
