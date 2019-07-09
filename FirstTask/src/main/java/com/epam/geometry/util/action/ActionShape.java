package com.epam.geometry.util.action;

import com.epam.geometry.entity.shape.impl.ShapeImpl;
import com.epam.geometry.util.action.def.DefaultActionClass;
import com.epam.geometry.util.action.impl.ActionShapeImpl;

public class ActionShape<T extends ShapeImpl> implements ActionShapeImpl {

    private ActionShapeImpl action;

    public ActionShape() {
        this(new DefaultActionClass());
    }

    public ActionShape(ActionShapeImpl action) {
        this.action = action;
    }

    @Override
    public int calculateSquare(ShapeImpl shape) {
        return 0;
    }

    public void setAction(ActionShapeImpl action) {
        this.action = action;
    }
}
