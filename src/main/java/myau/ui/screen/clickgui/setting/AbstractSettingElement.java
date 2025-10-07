package myau.ui.screen.clickgui.setting;

import myau.ui.element.LinkedElement;
import myau.ui.setting.*;

import java.util.function.Consumer;

import static myau.ui.screen.clickgui.Information.WIDTH;

public abstract class AbstractSettingElement<V extends Setting<?>> extends LinkedElement {

    protected final V setting;

    public AbstractSettingElement(V setting) {
        this.setting = setting;
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        return isHovered(getX(), getY(), WIDTH, height(), mouseX, mouseY);
    }

    @Override
    public int getX() {
        return prev.getX();
    }

    @Override
    public int getY() {
        return prev.getY() + prev.height();
    }

    public static void create(Setting<?> setting, Consumer<LinkedElement> action) {
        if (setting instanceof BooleanSetting) {
            action.accept(new BooleanSettingElement((BooleanSetting) setting));
        }
        if (setting instanceof FloatSetting) {
            action.accept(new FloatSettingElement((FloatSetting) setting));
        }
        if (setting instanceof IntSetting) {
            action.accept(new IntSettingElement((IntSetting) setting));
        }
        if (setting instanceof ModeSetting) {
            action.accept(new ModeSettingElement((ModeSetting) setting));
        }
        if (setting instanceof TextSetting) {
            action.accept(new TextSettingElement((TextSetting) setting));
        }
    }
}
