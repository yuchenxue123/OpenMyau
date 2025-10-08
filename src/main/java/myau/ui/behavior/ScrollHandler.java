package myau.ui.behavior;

import myau.ui.data.MutablePosition;
import myau.ui.data.Position;
import myau.ui.data.PositionData;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ScrollHandler implements Position {

    private final MutablePosition scroll = PositionData.zero();

    public void handleMouseScrolled() {
        if (Mouse.hasWheel()) {
            int wheel = Mouse.getDWheel();

            if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
                scroll.setX(scroll.getX() + wheel / 4);
            } else {
                scroll.setY(scroll.getY() + wheel / 4);
            }
        }

    }

    @Override
    public int getX() {
        return scroll.getX();
    }

    @Override
    public int getY() {
        return scroll.getY();
    }
}
