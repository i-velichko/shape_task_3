package com.epam.thirdtask.util;

public class TriangleIdGenerator {
    private static long counter;

    public TriangleIdGenerator() {
    }

    public static long generateId() {
        return ++counter;
    }
}
