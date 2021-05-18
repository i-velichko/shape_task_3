package com.epam.thirdtask.entity;

public class TriangleParameters {
    private double perimeter;
    private double area;

    public TriangleParameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public TriangleParameters() {
    }

    public TriangleParameters(TriangleParameters parameters) {
        area = parameters.area;
        perimeter = parameters.perimeter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TriangleParameters that = (TriangleParameters) o;

        if (Double.compare(that.getPerimeter(), getPerimeter()) != 0) {
            return false;
        }
        return Double.compare(that.getArea(), getArea()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPerimeter());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getArea());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("TriangleParameters{");
        builder.append("perimeter=").append(perimeter);
        builder.append(", area=").append(area);
        builder.append('}');
        return builder.toString();
    }
}
