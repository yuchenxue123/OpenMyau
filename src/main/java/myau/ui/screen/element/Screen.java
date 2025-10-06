package myau.ui.screen.element;

public interface Screen {

    default void drawScreen(int mouseX, int mouseY, float deltaTime) {};

    default void mouseClicked(int mouseX, int mouseY, int button) {};

    default void mouseReleased(int mouseX, int mouseY, int button) {};

    default void keyTyped(char character, int keyCode) {};

    default void onClose() {};
}
