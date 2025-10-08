package myau.ui.screen.clickgui;

import myau.module.Category;
import myau.ui.DrawContext;
import myau.ui.data.PositionData;
import myau.ui.element.CompositeLinkedElement;
import myau.ui.behavior.ScrollHandler;

import static myau.ui.screen.clickgui.Information.*;

public class ClickMainElement extends CompositeLinkedElement {

    private final ScrollHandler handler = new ScrollHandler();

    public ClickMainElement build() {
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            add(new CategoryElement(
                    categories[i],
                    PositionData.of(START_X + i * (WIDTH + CATEGORY_SPACE), START_Y),
                    handler
            ).build());
        }
        return this;
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        handler.handleMouseScrolled();

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }

    @Override
    public boolean isHovered(int mouseX, int mouseY) {
        // haha
        return false;
    }
}
