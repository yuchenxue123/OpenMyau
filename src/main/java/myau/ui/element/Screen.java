package myau.ui.element;

import myau.ui.DrawContext;

public interface Screen {

    default void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {}

    default void mouseClicked(int mouseX, int mouseY, int button) {}

    default void mouseReleased(int mouseX, int mouseY, int button) {}

    default void keyTyped(char character, int keyCode) {}

    default void onClose() {}

}
