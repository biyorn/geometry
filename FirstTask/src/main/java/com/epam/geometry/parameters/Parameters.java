package com.epam.geometry.parameters;

import com.epam.geometry.action.pyramid.PyramidLogic;

public class Parameters {

    private static final PyramidLogic logic = new PyramidLogic();
    private double volume;
    private double square;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "volume=" + volume +
                ", square=" + square +
                '}';
    }
}
