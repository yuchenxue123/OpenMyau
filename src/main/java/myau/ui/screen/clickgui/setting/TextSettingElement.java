package myau.ui.screen.clickgui.setting;

import myau.ui.DrawContext;
import myau.ui.setting.TextSetting;

import static myau.ui.screen.clickgui.Information.*;

public class TextSettingElement extends AbstractSettingElement<TextSetting> {

    public TextSettingElement(TextSetting setting) {
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
                setting.name() + " : " + setting.value(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - context.height()) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }
}
