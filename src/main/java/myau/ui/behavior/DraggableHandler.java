package myau.ui.behavior;

import myau.ui.data.MutablePosition;
import myau.ui.data.Position;
import myau.ui.data.PositionData;

public class DraggableHandler implements Position {

    private final MutablePosition position;
    private final MutablePosition drag = PositionData.zero();

    private boolean dragging;

    public DraggableHandler(MutablePosition position) {
        this.position = position;
    }

    public void onUpdatePosition(int mouseX, int mouseY) {
        if (dragging) {
            position.set(mouseX - drag.getX(), mouseY -  drag.getY());
        }
    }

    public void onMousePressed(int mouseX, int mouseY, int button, boolean hovered) {
        if (hovered && button == 0) {
            dragging = true;
            drag.set(mouseX - getX(), mouseY - getY());
        }
    }

    public void onMouseReleased(int mouseX, int mouseY, int button) {
        if (button == 0) {
            dragging = false;
        }
    }

    public void onClose() {
        dragging = false;
    }

    @Override
    public int getX() {
        return position.getX();
    }

    @Override
    public int getY() {
        return position.getY();
    }
}
