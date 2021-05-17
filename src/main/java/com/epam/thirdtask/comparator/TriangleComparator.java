package com.epam.thirdtask.comparator;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Triangle> {
    ID {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Long.compare(triangle1.getTriangleId(), triangle2.getTriangleId());
        }
    },
    PERIMETER {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            TriangleCalculateServiceImpl service = new TriangleCalculateServiceImpl();
            double perimeter1 = 0;
            try {
                perimeter1 = service.trianglePerimeterCalculate(triangle1);
            } catch (TriangleException e) {
                e.printStackTrace();
            }
            double perimeter2 = 0;
            try {
                perimeter2 = service.trianglePerimeterCalculate(triangle2);
            } catch (TriangleException e) {
                e.printStackTrace();
            }
            return Double.compare(perimeter1, perimeter2);
        }
    },
    AREA {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            TriangleCalculateServiceImpl service = new TriangleCalculateServiceImpl();
            double area1 = 0;
            try {
                area1 = service.triangleAreaCalculate(triangle1);
            } catch (TriangleException e) {
                e.printStackTrace();
            }
            double area2 = 0;
            try {
                area2 = service.trianglePerimeterCalculate(triangle2);
            } catch (TriangleException e) {
                e.printStackTrace();
            }
            return Double.compare(area1, area2);
        }
    }

}
