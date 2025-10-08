package myau.ui.data;

import myau.ui.RenderUtils;

public class Rectangle implements Rect {

    private final Position position;
    private final int width;
    private final int height;

    public Rectangle(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height) {
        this.position = PositionData.of(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return position.getX();
    }

    @Override
    public int getY() {
        return position.getY();
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        return RenderUtils.isHovered(getX(), getY(), width(), height(), mouseX, mouseY);
    }
}
