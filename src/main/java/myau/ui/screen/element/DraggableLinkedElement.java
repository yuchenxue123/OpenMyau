package myau.ui.screen.element;

import myau.ui.screen.data.PositionData;

public abstract class DraggableLinkedElement extends CompositeLinkedElement implements Moveable {
    private int baseX;
    private int baseY;

    public DraggableLinkedElement(int x, int y) {
        this.baseX = x;
        this.baseY = y;
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
            drag = new PositionData(mouseX - baseX, mouseY - baseY);
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
        this.baseX = x;
        this.baseY = y;
    }

    @Override
    public int getX() {
        return baseX;
    }

    @Override
    public int getY() {
        return baseY;
    }
}
