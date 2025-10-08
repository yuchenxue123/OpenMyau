package myau.ui.screen.clickgui;

import myau.module.Category;
import myau.ui.DrawContext;
import myau.ui.behavior.DraggableHandler;
import myau.ui.data.PositionData;
import myau.ui.element.DraggableLinkedElement;
import myau.ui.data.Position;

import static myau.ui.screen.clickgui.Information.*;

public class CategoryElement extends DraggableLinkedElement {

    private final Category category;

    private final Position scroll;

    public CategoryElement(Category category, Position scroll) {
        super(new DraggableHandler(
                PositionData.of(START_X + category.id * (WIDTH + CATEGORY_SPACE), START_Y)
        ));
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
                width(), height(),
                CATEGORY_COLOR.getRGB()
        );

        context.drawText(
                category.name(),
                getX() + (width() - context.width(category.name())) / 2f,
                getY() + (height() - context.height()) / 2f,
                DEFAULT_COLOR.getRGB()
        );
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public int getX() {
        return super.getX() + scroll.getX();
    }

    @Override
    public int getY() {
        return super.getY() + scroll.getY();
    }

    @Override
    public int width() {
        return WIDTH;
    }

    @Override
    public int height() {
        return HEIGHT;
    }
}
