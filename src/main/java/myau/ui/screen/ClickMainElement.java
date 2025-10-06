package myau.ui.screen;

import myau.module.Category;
import myau.ui.screen.data.PositionData;
import myau.ui.screen.element.CompositeLinkedElement;
import myau.ui.screen.element.ScrollHandler;

import static myau.ui.screen.Information.*;

public class ClickMainElement extends CompositeLinkedElement {

    private final ScrollHandler handler = new ScrollHandler();

    public ClickMainElement build() {
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            add(new CategoryElement(
                    categories[i],
                    new PositionData(START_X + i * (WIDTH + CATEGORY_SPACE), START_Y),
                    handler
            ).build());
        }
        return this;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {

        handler.handleMouseScrolled();

        super.drawScreen(mouseX, mouseY, deltaTime);
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        // haha
        return false;
    }
}
