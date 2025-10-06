package myau.ui.screen;

import javafx.geometry.Pos;
import myau.module.Category;
import myau.ui.RenderUtils;
import myau.ui.screen.element.DraggableLinkedElement;
import myau.ui.screen.element.Position;

import static myau.ui.screen.Information.*;

public class CategoryElement extends DraggableLinkedElement {

    private final Category category;

    private final Position scroll;

    public CategoryElement(Category category, Position position, Position scroll) {
        super(position.getX(), position.getY());
        this.scroll = scroll;
        this.category = category;
    }

    public CategoryElement build() {
        category.getModules().forEach(module -> add(new ModuleElement(module).build()));
        return this;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {

        handleDraggableDrawScreen(mouseX, mouseY, deltaTime);

        RenderUtils.drawRect(
                getX(), getY(),
                WIDTH, height(),
                CATEGORY_COLOR.getRGB()
        );

        font.drawStringWithShadow(
                category.name(),
                getX() + (WIDTH - font.getStringWidth(category.name())) / 2f,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                DEFAULT_COLOR.getRGB()
        );

        super.drawScreen(mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        handleDraggableMouseClicked(mouseX, mouseY, button);

        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {

        handleDraggableMouseReleased(mouseX, mouseY, button);

        super.mouseReleased(mouseX, mouseY, button);
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
