package myau.ui.screen.clickgui;

import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class ClickScreen extends GuiScreen {

    private static ClickScreen INSTANCE;

    public static ClickScreen getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClickScreen();
        }
        return INSTANCE;
    }

    private final ClickMainElement main = new ClickMainElement().build();

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {
        main.drawScreen(mouseX, mouseY, deltaTime);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int button) {
        main.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int button) {
        main.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        main.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        main.onClose();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
