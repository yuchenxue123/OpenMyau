package myau.ui.screen.element;

public interface Screen {

    void drawScreen(int mouseX, int mouseY, float deltaTime);

    void mouseClicked(int mouseX, int mouseY, int button);

    void mouseReleased(int mouseX, int mouseY, int button);

}
