package myau.ui.screen.element;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import static myau.ui.screen.Information.HEIGHT;

public abstract class DefaultElement implements Screen {
    protected FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

    public abstract boolean isHovered(int mouseX, int mouseY);

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
