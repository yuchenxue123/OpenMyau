package myau.ui.screen.setting;

import myau.ui.RenderUtils;
import myau.ui.setting.ModeSetting;

import static myau.ui.screen.Information.*;

public class ModeSettingElement extends AbstractSettingElement<ModeSetting> {

    public ModeSettingElement(ModeSetting setting) {
        super(setting);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {

        RenderUtils.drawRect(
                getX(), getY(),
                WIDTH, height(),
                SETTINGS_COLOR
        );

        font.drawStringWithShadow(
                setting.name() + " -> " + setting.getMode().toLowerCase(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(mouseX, mouseY, deltaTime);
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
