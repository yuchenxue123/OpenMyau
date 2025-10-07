package myau.module.modules;

import myau.module.Category;
import myau.module.Module;
import myau.ui.screen.clickgui.ClickScreen;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Module {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public ClickGui() {
        super("ClickGui", Category.RENDER, true);
        setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnabled() {
        mc.displayGuiScreen(ClickScreen.getInstance());
        setEnabled(false);
    }
}
