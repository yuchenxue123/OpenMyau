package myau.ui.element;

import myau.ui.RenderUtils;
import myau.ui.behavior.Openable;
import myau.ui.data.Rect;

public abstract class DefaultElement implements Screen, Rect, Openable {

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int width() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int getWidth() {
        return width();
    }

    @Override
    public int getHeight() {
        return height();
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        return RenderUtils.isHovered(getX(), getY(), width(), height(), mouseX, mouseY);
    }

}
