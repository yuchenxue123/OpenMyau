package myau.ui.screen;

import myau.ui.DrawContext;
import myau.ui.data.Position;
import myau.ui.data.Rect;
import myau.ui.element.DefaultElement;

public class TextBox extends DefaultElement {
    private final Rect rect;
    private final Position offset;

    private String text = "";

    private boolean focused;

    public TextBox(Rect rectangle, Position position, String text) {
        this.rect = rectangle;
        this.offset = position;
        this.text = text;
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {

    }

    @Override
    public int getX() {
        return rect.getX() + offset.getX();
    }

    @Override
    public int getY() {
        return rect.getY() +  offset.getY();
    }
}
