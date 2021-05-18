package com.epam.thirdtask.parser;

import com.epam.thirdtask.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataParser {
    private final static Logger LOGGER = LogManager.getLogger();

    public double[] parseStringToDouble(String dataLine) throws TriangleException {
        if (dataLine == null) {
            throw new TriangleException("Line for parsing is null.");
        }
        String[] charactersTriangle = dataLine.split(" ");
        double[] pointNumbers = new double[charactersTriangle.length];
        for (int i = 0; i < charactersTriangle.length; i++) {
            try {
                pointNumbers[i] = Double.parseDouble(charactersTriangle[i].trim());
            } catch (NumberFormatException e) {
                LOGGER.error("This characters can not be a parse to double ." + e.getMessage());
                throw new TriangleException();
            }
        }
        return pointNumbers;
    }

}
