package com.epam.geometry.entity.point;

public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }

    @Override
    public int hashCode() {
        double result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return (int) result;
    }
}
