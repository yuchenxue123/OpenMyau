package myau.ui.element;

import myau.ui.data.Position;

public abstract class LinkedElement extends DefaultElement implements Position {

    public LinkedElement prev;

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    public boolean visible() {
        return true;
    }
}
