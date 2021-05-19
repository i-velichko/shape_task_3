package com.epam.thirdtask.comparator;

import com.epam.thirdtask.entity.Triangle;
import com.epam.thirdtask.service.impl.TriangleCalculateServiceImpl;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Triangle> {
    ID {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Long.compare(triangle1.getId(), triangle2.getId());
        }
    },
    PERIMETER {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            TriangleCalculateServiceImpl service = new TriangleCalculateServiceImpl();
            double perimeter1 = service.trianglePerimeterCalculate(triangle1);
            double perimeter2 = service.trianglePerimeterCalculate(triangle2);
            return Double.compare(perimeter1, perimeter2);
        }
    },
    AREA {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            TriangleCalculateServiceImpl service = new TriangleCalculateServiceImpl();
            double area1 = service.triangleAreaCalculate(triangle1);
            double area2 = service.trianglePerimeterCalculate(triangle2);
            return Double.compare(area1, area2);
        }
    }

}
