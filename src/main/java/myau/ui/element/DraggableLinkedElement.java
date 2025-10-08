package myau.ui.element;

import myau.ui.DrawContext;
import myau.ui.behavior.DraggableHandler;
import myau.ui.behavior.Drawable;

public abstract class DraggableLinkedElement extends CompositeLinkedElement implements Drawable {
    private final DraggableHandler handler;

    public DraggableLinkedElement(DraggableHandler handler) {
        this.handler = handler;
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        handler.onUpdatePosition(mouseX, mouseY);

        render(context, mouseX, mouseY, deltaTime);

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }


    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        handler.onMousePressed(mouseX, mouseY, button, isHovered(mouseX, mouseY));

        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {

        handler.onMouseReleased(mouseX, mouseY, button);

        super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void onClose() {

        handler.onClose();

        super.onClose();
    }

    @Override
    public int getX() {
        return handler.getX();
    }

    @Override
    public int getY() {
        return handler.getY();
    }
}