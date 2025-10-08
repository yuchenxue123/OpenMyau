package myau.ui.screen.clickgui.setting;

import myau.ui.DrawContext;
import myau.ui.MathUtils;
import myau.ui.RenderUtils;
import myau.ui.setting.FloatSetting;

import static myau.ui.screen.clickgui.Information.*;

public class FloatSettingElement extends AbstractSettingElement<FloatSetting> {

    public FloatSettingElement(FloatSetting setting) {
        super(setting);
    }

    private boolean dragging = false;

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        if (dragging) {
            float deltaX = MathUtils.limit(mouseX - getX(), 0, WIDTH);

            float newValue = MathUtils.interpolate(deltaX / WIDTH, setting.min(), setting.max());

            float format = MathUtils.format(newValue, 0.05f, 2);

            float wrap = MathUtils.limit(format, setting.min(), setting.max());

            setting.set(wrap);
        }

        context.drawRect(
                getX(), getY(),
                WIDTH, height(),
                SETTINGS_COLOR
        );

        // 条
        float process = MathUtils.limit((setting.value() - setting.min()) / (setting.max() - setting.min()));
        int width = MathUtils.limit((int) (process * WIDTH), 0, WIDTH);
        context.drawRect(
                getX(), getY(),
                width, height(),
                SLIDER_COLOR
        );

        context.drawText(
                setting.name() + " : " + setting.value(),
                getX() + SETTING_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
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
