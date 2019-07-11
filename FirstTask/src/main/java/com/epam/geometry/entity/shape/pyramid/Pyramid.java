package com.epam.geometry.entity.shape.pyramid;

import com.epam.geometry.entity.point.Point;

public class Pyramid {

    private Point point;
    private double sideRibLength;
    private double baseEdgeLength;

    public Pyramid(Point point, int sideRibLength, int baseEdgeLength) {
        this.point = point;
        this.sideRibLength = sideRibLength;
        this.baseEdgeLength = baseEdgeLength;
    }

    public Point getPoint() {
        return point;
    }

    public double getSideRibLength() {
        return sideRibLength;
    }

    public double getBaseEdgeLength() {
        return baseEdgeLength;
    }

    @Override
    public int hashCode() {
        double result = 17;
        result = 31 * result + point.hashCode();
        result = 31 * result + sideRibLength;
        result = 31 * result + baseEdgeLength;
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Pyramid other = (Pyramid) obj;
        return point.equals(other.point) &&
                sideRibLength == other.sideRibLength &&
                baseEdgeLength == other.baseEdgeLength;
    }
}
