package com.epam.thirdtask.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataValidatorTest {
    private final static String CORRECT_LINE = "1.0 2.0 3.0 4.0 5.0 6.0";
    private final static String UNCORRECTED_LINE = "Help me!";
    private DataValidator dataValidator;

    @BeforeEach
    void setUp() {
        dataValidator = new DataValidator();
    }

    @Test
    void isStringValid() {
        Assertions.assertTrue(dataValidator.isStringValid(CORRECT_LINE));
    }

    @Test
    void isStringNotValid() {
        Assertions.assertFalse(dataValidator.isStringValid(UNCORRECTED_LINE));
    }
}