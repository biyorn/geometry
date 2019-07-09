package com.epam.geometry.util.action;

import com.epam.geometry.entity.shape.impl.ShapeImpl;
import com.epam.geometry.util.action.impl.ActionImpl;

public class ActionShape {

    private ActionImpl action;
    private ShapeImpl shape;

    public ActionShape() {}

    public ActionShape(ShapeImpl shape, ActionImpl action) {
        this.shape = shape;
        this.action = action;
    }

    public int calculateSquare() {
        return 0;
    }

}
