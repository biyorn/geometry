package com.epam.geometry.util.action.def;

import com.epam.geometry.entity.shape.impl.ShapeImpl;
import com.epam.geometry.util.action.impl.ActionShapeImpl;

public class DefaultActionClass implements ActionShapeImpl {

    @Override
    public int calculateSquare(ShapeImpl shape) {
        return 0;
    }
}
