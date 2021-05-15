package com.epam.thirdtask.parser;

import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {
    private final static String LINE_BEFORE_PARSING = "-1.1 -9.2 10.3 0.4 -5.5 6.9";
    private final static double[] EXPECTED_ARRAY ={-1.1, -9.2, 10.3, 0.4, -5.5, 6.9,};
    private DataParser dataParser;


    @BeforeEach
    void setUp() {
        dataParser = new DataParser();
    }

    @Test
    void parseStringToDouble() throws TriangleException {
        double[] actualArray = dataParser.parseStringToDouble(LINE_BEFORE_PARSING);
        Assertions.assertArrayEquals(EXPECTED_ARRAY, actualArray);
    }
}