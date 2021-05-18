package com.epam.thirdtask.observer;

import com.epam.thirdtask.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {

    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
