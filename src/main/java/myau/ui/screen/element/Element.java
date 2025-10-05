package myau.ui.screen.element;

import java.util.ArrayList;
import java.util.List;

public abstract class Element implements Screen {
    private final List<Element> children = new ArrayList<>();

    public void add(Element child) {
        children.add(child);
    }

    public void clear() {
        children.clear();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {
        children.forEach(c -> c.drawScreen(mouseX, mouseY, deltaTime));
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        children.forEach(c -> c.mouseClicked(mouseX, mouseY, button));
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {
        children.forEach(c -> c.mouseReleased(mouseX, mouseY, button));
    }
}
