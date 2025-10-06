package myau.ui;

import net.minecraft.client.gui.Gui;

import java.awt.*;

public class RenderUtils {

    public static void drawRect(int x, int y, int w, int h, Color color) {
        Gui.drawRect(x, y, x + w, y + h, color.getRGB());
    }

    public static void drawRect(int x, int y, int w, int h, int color) {
        Gui.drawRect(x, y, x + w, y + h, color);
    }
}
