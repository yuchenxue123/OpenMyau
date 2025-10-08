package myau.ui.element;

import myau.ui.behavior.Hovered;
import myau.ui.data.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import static myau.ui.screen.clickgui.Information.HEIGHT;

public abstract class DefaultElement implements Screen, Position, Hovered {

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    public int height() {
        return HEIGHT;
    }

    public int getTotalHeight() {
        return height();
    }

    protected boolean isHovered(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}
