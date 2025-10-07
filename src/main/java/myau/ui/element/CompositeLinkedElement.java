package myau.ui.element;

public abstract class CompositeLinkedElement extends LinkedElement {
    public final LinkedElementList children = new LinkedElementList(this);

    public void add(LinkedElement child) {
        children.add(child);
    }

    public void clear() {
        children.clear();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float deltaTime) {
        if (!isActive()) return;
        for (LinkedElement element : children) {
            if (!element.visible()) continue;
            element.drawScreen(mouseX, mouseY, deltaTime);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (!isActive()) return;
        for (LinkedElement element : children) {
            if (!element.visible()) continue;
            element.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {
        if (!isActive()) return;
        for (LinkedElement element : children) {
            if (!element.visible()) continue;
            element.mouseReleased(mouseX, mouseY, button);
        }
    }

    @Override
    public void keyTyped(char character, int keyCode) {
        if (!isActive()) return;
        for (LinkedElement element : children) {
            if (!element.visible()) continue;
            element.keyTyped(character, keyCode);
        }
    }

    @Override
    public void onClose() {
        if (!isActive()) return;

        for (LinkedElement element : children) {
            element.onClose();
        }
    }

    public LinkedElement get(int index) {
        return children.get(index);
    }

    public boolean isActive() {
        return true;
    }
}
