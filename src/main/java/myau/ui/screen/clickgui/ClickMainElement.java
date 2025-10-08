package myau.ui.screen.clickgui;

import myau.module.Category;
import myau.ui.DrawContext;
import myau.ui.behavior.ScrollHandler;
import myau.ui.element.DefaultElement;
import myau.ui.element.LinkedElement;
import myau.ui.element.Screen;

import java.util.ArrayList;

public class ClickMainElement extends DefaultElement {

    private final ArrayList<LinkedElement> elements = new ArrayList<>();

    private final ScrollHandler scrollHandler = new ScrollHandler();

    public ClickMainElement build() {
        for (Category category : Category.values()) {
            elements.add(new CategoryElement(category, scrollHandler).build());
        }
        return this;
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        scrollHandler.handleMouseScrolled();

        elements.forEach(element -> element.drawScreen(context, mouseX, mouseY, deltaTime));
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        elements.forEach(element -> element.mouseClicked(mouseX, mouseY, button));
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {
        elements.forEach(element -> element.mouseReleased(mouseX, mouseY, button));
    }

    @Override
    public void keyTyped(char character, int keyCode) {
        elements.forEach(element -> element.keyTyped(character, keyCode));
    }

    @Override
    public void onClose() {
        elements.forEach(Screen::onClose);
    }
}
