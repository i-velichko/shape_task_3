package com.epam.thirdtask.factory;

import com.epam.thirdtask.entity.Triangle;

public class TriangleFactory {
    private final static int POINT_A_X = 1;
    private final static int POINT_A_Y = 2;
    private final static int POINT_B_X = 3;
    private final static int POINT_B_Y = 4;
    private final static int POINT_C_X = 5;
    private final static int POINT_C_Y = 6;

    public static Triangle createTriangle(double[] values) {
        return new Triangle();
    }
}
