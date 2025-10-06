package myau.ui.screen.element;

import myau.ui.screen.data.PositionData;

public abstract class DraggableLinkedElement extends CompositeLinkedElement implements Moveable {
    private int x;
    private int y;

    public DraggableLinkedElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private boolean dragging = false;
    private PositionData drag = new PositionData(0, 0);

    protected void handleDraggableDrawScreen(int mouseX, int mouseY, float deltaTime) {
        if (dragging) {
            move(mouseX - drag.getX(), mouseY -  drag.getY());
        }
    }

    protected void handleDraggableMouseClicked(int mouseX, int mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            dragging = true;
            drag = new PositionData(mouseX - getX(), mouseY - getY());
        }
    }

    protected void handleDraggableMouseReleased(int mouseX, int mouseY, int button) {
        dragging = false;
    }

    @Override
    public void onClose() {

        dragging = false;

        super.onClose();
    }

    @Override
    public void move(int x, int y) {
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
