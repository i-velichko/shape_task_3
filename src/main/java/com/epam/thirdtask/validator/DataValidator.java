package com.epam.thirdtask.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String DATA_REGEX = "(-?\\d+.\\d+\\s*){6}";

    public boolean isStringValid(String dataLine) {
        boolean result = false;

        if (dataLine != null) {
            Pattern pattern = Pattern.compile(DATA_REGEX);
            Matcher matcher = pattern.matcher(dataLine);

            if (matcher.matches()) {
                LOGGER.info(" Data string " + dataLine + " is valid.");
                result = true;
            } else {
                LOGGER.info(" Data string " + dataLine + " is not valid.");
                result = false;
            }

        }
        return result;
    }

}