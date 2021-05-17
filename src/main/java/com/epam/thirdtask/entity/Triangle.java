package com.epam.thirdtask.entity;

import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.observer.TriangleEvent;
import com.epam.thirdtask.observer.TriangleObservable;
import com.epam.thirdtask.observer.TriangleObserver;
import com.epam.thirdtask.observer.impl.TriangleObserverImpl;
import com.epam.thirdtask.util.TriangleIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements TriangleObservable {
    private Long triangleId;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private List<TriangleObserver> observers = new ArrayList<>();

    public Triangle(Long triangleId, Point pointA, Point pointB, Point pointC) {
        this.triangleId = TriangleIdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle() {
    }

    public Long getTriangleId() {
        return triangleId;
    }

    public void setTriangleId(Long triangleId) {
        this.triangleId = triangleId;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void addObserver(TriangleObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }

    }

    @Override
    public void removeObserver(TriangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() throws TriangleException {
        TriangleEvent event = new TriangleEvent(this);
        if (!observers.isEmpty()) {
            for (TriangleObserver observer : observers) {
                observer.parametersChanged(event);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        if (getPointA() != null ? !getPointA().equals(triangle.getPointA()) : triangle.getPointA() != null) {
            return false;
        }
        if (getPointB() != null ? !getPointB().equals(triangle.getPointB()) : triangle.getPointB() != null) {
            return false;
        }
        return getPointC() != null ? getPointC().equals(triangle.getPointC()) : triangle.getPointC() == null;
    }

    @Override
    public int hashCode() {
        int result = getPointA() != null ? getPointA().hashCode() : 0;
        result = 31 * result + (getPointB() != null ? getPointB().hashCode() : 0);
        result = 31 * result + (getPointC() != null ? getPointC().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("pointA=").append(pointA);
        sb.append(", pointB=").append(pointB);
        sb.append(", pointC=").append(pointC);
        sb.append('}');
        return sb.toString();
    }

}
