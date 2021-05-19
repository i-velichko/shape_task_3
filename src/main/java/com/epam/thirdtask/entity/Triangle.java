package com.epam.thirdtask.entity;

import com.epam.thirdtask.exception.TriangleException;
import com.epam.thirdtask.observer.TriangleEvent;
import com.epam.thirdtask.observer.TriangleObservable;
import com.epam.thirdtask.observer.TriangleObserver;
import com.epam.thirdtask.util.TriangleIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements TriangleObservable {
    private Long id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private List<TriangleObserver> observers = new ArrayList<>();

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.id = TriangleIdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle() {
        this.id = TriangleIdGenerator.generateId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) throws TriangleException {
        if (pointA == null) {
            throw new TriangleException("You can not create triangle with null point(s)");
        }
        this.pointA = pointA;
        notifyObserver();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) throws TriangleException {
        if (pointA == null) {
            throw new TriangleException("You can not create triangle with null point(s)");
        }
        this.pointB = pointB;
        notifyObserver();
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

        if (getId() != null ? !getId().equals(triangle.getId()) : triangle.getId() != null) {
            return false;
        }
        if (getPointA() != null ? !getPointA().equals(triangle.getPointA()) : triangle.getPointA() != null) {
            return false;
        }
        if (getPointB() != null ? !getPointB().equals(triangle.getPointB()) : triangle.getPointB() != null) {
            return false;
        }
        if (getPointC() != null ? !getPointC().equals(triangle.getPointC()) : triangle.getPointC() != null) {
            return false;
        }
        return observers != null ? observers.equals(triangle.observers) : triangle.observers == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPointA() != null ? getPointA().hashCode() : 0);
        result = 31 * result + (getPointB() != null ? getPointB().hashCode() : 0);
        result = 31 * result + (getPointC() != null ? getPointC().hashCode() : 0);
        result = 31 * result + (observers != null ? observers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Triangle{");
        builder.append("id=").append(id);
        builder.append(", pointA=").append(pointA);
        builder.append(", pointB=").append(pointB);
        builder.append(", pointC=").append(pointC);
        builder.append('}');
        return builder.toString();
    }
}
