package myau.ui.data;

import myau.ui.element.Position;

public class PositionData implements Position {

    private final int x;
    private final int y;

    public PositionData(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
