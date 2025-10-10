package myau.ui.screen.code;

import myau.ui.DrawContext;
import myau.ui.data.PositionData;
import myau.ui.data.Rectangle;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class CodeGui extends GuiScreen {

    private static CodeGui instance;

    private final TextBox box = new TextBox(new Rectangle(20, 20, 250, 16), PositionData.zero());

    public static CodeGui getInstance() {
        if (instance == null) {
            instance = new CodeGui();
        }
        return instance;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        box.drawScreen(DrawContext.INSTANCE, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        box.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        box.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);

        box.keyTyped(typedChar, keyCode);
    }
}
