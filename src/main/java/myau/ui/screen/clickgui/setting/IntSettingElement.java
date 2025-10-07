package myau.ui.screen.clickgui.setting;

import myau.ui.MathUtils;
import myau.ui.RenderUtils;
import myau.ui.setting.IntSetting;

import static myau.ui.screen.clickgui.Information.*;

public class IntSettingElement extends AbstractSettingElement<IntSetting> {

    public IntSettingElement(IntSetting setting) {
        super(setting);
    }

    private boolean dragging = false;

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {

        if (dragging) {
            float deltaX = MathUtils.limit(mouseX - getX(), 0, WIDTH);

            int newValue = (int) MathUtils.interpolate(deltaX / WIDTH, setting.min(), setting.max());

            int wrap = Math.min(setting.max(), Math.max(setting.min(), newValue));

            setting.set(wrap);
        }

        RenderUtils.drawRect(
                getX(), getY(),
                WIDTH, height(),
                SETTINGS_COLOR
        );

        // 条
        float process = MathUtils.limit((float) (setting.value() - setting.min()) / (setting.max() - setting.min()));
        int width = MathUtils.limit((int) (process * WIDTH), 0, WIDTH);
        RenderUtils.drawRect(
                getX(), getY(),
                width, height(),
                SLIDER_COLOR
        );

        font.drawStringWithShadow(
                setting.name() + " : " + setting.value(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY) && button == 0) {
            dragging = true;
        }

        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {

        dragging = false;

        super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void onClose() {

        dragging = false;

        super.onClose();
    }
}
