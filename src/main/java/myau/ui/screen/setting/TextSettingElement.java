package myau.ui.screen.setting;

import myau.ui.RenderUtils;
import myau.ui.setting.TextSetting;

import static myau.ui.screen.Information.*;

public class TextSettingElement extends AbstractSettingElement<TextSetting> {

    public TextSettingElement(TextSetting setting) {
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
                setting.name() + " : " + setting.value(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(mouseX, mouseY, deltaTime);
    }
}
