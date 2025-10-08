package myau.ui.screen.clickgui;

import myau.Myau;
import myau.module.Module;
import myau.property.Property;
import myau.ui.DrawContext;
import myau.ui.RenderUtils;
import myau.ui.element.CompositeLinkedElement;
import myau.ui.element.LinkedElement;
import myau.ui.screen.clickgui.setting.AbstractSettingElement;

import java.util.ArrayList;

import static myau.ui.screen.clickgui.Information.*;

public class ModuleElement extends CompositeLinkedElement {

    private final Module module;

    public ModuleElement(Module module) {
        this.module = module;
    }

    public ModuleElement build() {
        ArrayList<Property<?>> properties = Myau.propertyManager.properties.get(module.getClass());
        properties.forEach(property -> AbstractSettingElement.create(property, this::add));
        return this;
    }

    private boolean opened = false;

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        context.drawRect(
                getX(), getY(),
                WIDTH, height(),
                MODULE_COLOR.getRGB()
        );

        context.drawText(
                module.getName().toLowerCase(),
                getX() + MODULE_TEXT_SIDE_SPACE,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                (module.isEnabled() ? ENABLED_COLOR : DEFAULT_COLOR).getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                module.toggle();
            }
            if (button == 1) {
                if (children.isNotEmpty()) {
                    opened = !opened;
                }
            }
        }

        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public int getTotalHeight() {
        int height = 0;
        for (LinkedElement child : children) {
            height += child.getTotalHeight();
        }
        return super.getTotalHeight() + (opened ? height : 0);
    }

    @Override
    public int getX() {
        return prev.getX();
    }

    @Override
    public int getY() {
        return prev.getY() + prev.getTotalHeight();
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        return isHovered(getX(), getY(), WIDTH, height(), mouseX, mouseY);
    }

    @Override
    public boolean isActive() {
        return super.isActive() && opened;
    }
}
