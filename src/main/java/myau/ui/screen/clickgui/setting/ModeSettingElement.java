package myau.ui.screen.clickgui.setting;

import myau.ui.DrawContext;
import myau.ui.setting.ModeSetting;

import static myau.ui.screen.clickgui.Information.*;

public class ModeSettingElement extends AbstractSettingElement<ModeSetting> {

    public ModeSettingElement(ModeSetting setting) {
        super(setting);
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        context.drawRect(
                getX(), getY(),
                width(), height(),
                SETTINGS_COLOR
        );

        context.drawText(
                setting.name() + " -> " + setting.getMode().toLowerCase(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - context.height()) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                setting.next();
            }
            if (button == 1) {
                setting.prev();
            }
        }

        super.mouseClicked(mouseX, mouseY, button);
    }
}
