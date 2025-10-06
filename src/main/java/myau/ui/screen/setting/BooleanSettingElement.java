package myau.ui.screen.setting;

import myau.ui.RenderUtils;
import myau.ui.setting.BooleanSetting;

import static myau.ui.screen.Information.*;

public class BooleanSettingElement extends AbstractSettingElement<BooleanSetting> {

    public BooleanSettingElement(BooleanSetting setting) {
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
                setting.name(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                (setting.value() ? ENABLED_COLOR : DEFAULT_COLOR).getRGB()
        );

        super.drawScreen(mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY) && button == 0) {
            setting.toggle();
        }

        super.mouseClicked(mouseX, mouseY, button);
    }
}
