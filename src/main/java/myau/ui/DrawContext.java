package myau.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class DrawContext {

    private final FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

    public void drawRect(int x, int y, int width, int height, Color color) {
        drawRect(x,y,width,height,color.getRGB());
    }

    public void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    public void drawText(String text, float x, float y, int color, boolean shadow) {
        font.drawString(text, x, y, color, shadow);
    }

    public void drawText(String text, int x, int y, int color, boolean shadow) {
        drawText(text, (float) x, (float) y, color, shadow);
    }

    public void drawText(String text, float x, float y, int color) {
        drawText(text, x, y, color, true);
    }

    public int width(String text) {
        return font.getStringWidth(text);
    }

    public int height() {
        return font.FONT_HEIGHT;
    }

    public void drawText(String text, int x, int y, int color) {
        drawText(text, x, y, color, true);
    }
}
