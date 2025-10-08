package myau.ui.screen.clickgui.setting;

import myau.ui.DrawContext;
import myau.ui.setting.BooleanSetting;

import static myau.ui.screen.clickgui.Information.*;

public class BooleanSettingElement extends AbstractSettingElement<BooleanSetting> {

    public BooleanSettingElement(BooleanSetting setting) {
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
                setting.name(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - context.height()) / 2f,
                (setting.value() ? ENABLED_COLOR : DEFAULT_COLOR).getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY) && button == 0) {
            setting.toggle();
        }

        super.mouseClicked(mouseX, mouseY, button);
    }
}
