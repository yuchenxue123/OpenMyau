package myau.ui.element;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ScrollHandler implements Position {
    private int scrollX = 0;
    private int scrollY = 0;

    public void handleMouseScrolled() {
        if (Mouse.hasWheel()) {
            int wheel = Mouse.getDWheel();

            if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
                scrollX += wheel / 4;
            } else {
                scrollY += wheel / 4;
            }
        }

    }

    @Override
    public int getX() {
        return scrollX;
    }

    @Override
    public int getY() {
        return scrollY;
    }
}
