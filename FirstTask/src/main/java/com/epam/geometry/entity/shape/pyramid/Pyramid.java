package com.epam.geometry.entity.shape.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.impl.ShapeImpl;

public class Pyramid implements ShapeImpl {

    private Point point;
    private int height;
    private int lengthEdge;
    private static final int INITIAL_VALUE = 10;

    public Pyramid() {
        this.point = new Point();
        this.height = INITIAL_VALUE;
        this.lengthEdge = INITIAL_VALUE;
    }

    public Pyramid(Point point, int height, int lengthEdge) {
        this.point = point;
        this.height = height;
        this.lengthEdge = lengthEdge;
    }

    public Point getPoint() {
        Point temp = new Point(point);
        return temp;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLengthEdge() {
        return lengthEdge;
    }

    public void setLengthEdge(int lengthEdge) {
        this.lengthEdge = lengthEdge;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + point.hashCode();
        result = 31 * result + height;
        result = 31 * result + lengthEdge;
        return result;
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
                height == other.height &&
                lengthEdge == other.lengthEdge;
    }
}
