package myau.ui.data;

public class PositionData implements MutablePosition {
    private int x;
    private int y;

    private PositionData(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static PositionData of(int x, int y) {
        return new PositionData(x, y);
    }

    public static PositionData of(Position position) {
        return new PositionData(position.getX(), position.getY());
    }

    public static PositionData zero() {
        return new PositionData(0, 0);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void set(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }
}
