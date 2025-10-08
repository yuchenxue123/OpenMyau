package myau.ui.element;

import myau.ui.data.Position;

public abstract class LinkedElement extends DefaultElement implements Position {

    public LinkedElement prev;

    public boolean visible() {
        return true;
    }
}
