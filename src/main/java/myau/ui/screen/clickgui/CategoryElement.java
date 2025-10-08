package myau.ui.screen.clickgui;

import myau.module.Category;
import myau.ui.DrawContext;
import myau.ui.behavior.DraggableHandler;
import myau.ui.data.MutablePosition;
import myau.ui.element.DraggableLinkedElement;
import myau.ui.data.Position;

import static myau.ui.screen.clickgui.Information.*;

public class CategoryElement extends DraggableLinkedElement {

    private final Category category;

    private final Position scroll;

    public CategoryElement(Category category, MutablePosition position, Position scroll) {
        super(new DraggableHandler(position));
        this.scroll = scroll;
        this.category = category;
    }

    public CategoryElement build() {
        category.getModules().forEach(module -> add(new ModuleElement(module).build()));
        return this;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTime) {
        context.drawRect(
                getX(), getY(),
                WIDTH, height(),
                CATEGORY_COLOR.getRGB()
        );

        context.drawText(
                category.name(),
                getX() + (WIDTH - font.getStringWidth(category.name())) / 2f,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        return isHovered(getX(), getY(), WIDTH, height(), mouseX, mouseY);
    }

    @Override
    public int getX() {
        return super.getX() + scroll.getX();
    }

    @Override
    public int getY() {
        return super.getY() + scroll.getY();
    }
}
