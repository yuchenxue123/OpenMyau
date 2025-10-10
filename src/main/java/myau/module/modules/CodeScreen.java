package myau.module.modules;

import myau.module.Category;
import myau.module.Module;
import myau.ui.screen.code.CodeGui;
import net.minecraft.client.Minecraft;

public class CodeScreen extends Module {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public CodeScreen() {
        super("CodeScreen", Category.RENDER, true);
    }

    @Override
    public void onEnabled() {
        mc.displayGuiScreen(CodeGui.getInstance());
        setEnabled(false);
    }
}
