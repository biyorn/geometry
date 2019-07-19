package com.epam.geometry.observable;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.id.CreationID;
import com.epam.geometry.observer.impl.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PyramidObservable extends Pyramid {

    private static final String ID = CreationID.getID().toString();
    private List<Observer> observerList = new ArrayList<>();

//    static {
//        UUID uuid = creationID.getID();
//        ID = uuid.toString();
//    }

    public PyramidObservable(Point point, double sideRibLength, double baseEdgeLength) {
        super(point, sideRibLength, baseEdgeLength);
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
        notifyAllObservers();
    }

    @Override
    public void setSideRibLength(double sideRibLength) {
        super.setSideRibLength(sideRibLength);
        notifyAllObservers();
    }

    @Override
    public void setBaseEdgeLength(double baseEdgeLength) {
        super.setBaseEdgeLength(baseEdgeLength);
        notifyAllObservers();
    }

    public String getID() {
        return ID;
    }

    public void attach(Observer observer){
        Optional<Observer> optionalObserver = Optional.ofNullable(observer);
        optionalObserver.ifPresent(observerList::add);
    }

    private void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}