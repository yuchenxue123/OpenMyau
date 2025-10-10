package myau.ui.screen.code;

import myau.Myau;
import myau.module.Module;
import myau.ui.DrawContext;
import myau.ui.data.Position;
import myau.ui.data.Rect;
import myau.ui.element.CompositeLinkedElement;
import myau.ui.element.LinkedElement;
import myau.util.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

public class TextBox extends CompositeLinkedElement {
    private final FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

    private final Rect rect;
    private final Position offset;

    private int lines = 0;

    private Color background = new Color(80, 80, 80);

    public TextBox(Rect rectangle, Position offset) {
        this(rectangle, offset, "");
        this.add(new Line("Test", this));
        this.add(new Line("import myau.module.Module;", this).setFocused(true));
        this.add(new Line("import myau.module.Category;", this));
        this.add(new Line("import myau.util.ChatUtil;", this));
        this.add(new Line("public class Test extends Module {", this));
        this.add(new Line("public Test() {", this));
        this.add(new Line("super(\"Test\", Category.MISC, false);", this));
        this.add(new Line("}", this));
        this.add(new Line("public void onEnabled() {", this));
        this.add(new Line("ChatUtil.sendMessage(\"Tesssssssssst\");", this));
        this.add(new Line("}", this));
        this.add(new Line("}", this));
    }

    public TextBox(Rect rectangle, Position position, String text) {
        this.rect = rectangle;
        this.offset = position;
    }

    @Override
    public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

        context.drawRect(getX(), getY(), width(), height(), background);

        String text = "Click To Compile The Module";
        context.drawText(
                text,
                getX() + (width() - font.getStringWidth(text)) / 2f,
                getY() + (height() - font.FONT_HEIGHT) / 2f,
                Color.white.getRGB()
        );

        super.drawScreen(context, mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

        if (isHovered(mouseX, mouseY) && button == 0) {
            try {
                Object test = JavaSourceCompiler.getInstance().compile(getFirstLine(), getFullText());
                if (test instanceof Module) {
                    Module module = (Module) test;
                    Myau.moduleManager.modules.put(module.getClass(), (Module) test);
                    ChatUtil.sendFormatted("Module " + module.getName() + " loaded");
                }
            } catch (IOException | ClassNotFoundException ignored) {
                ChatUtil.sendFormatted("Failed");
            }
        }

        super.mouseClicked(mouseX, mouseY, button);
    }

    public int add() {
        Line line = new Line("", this);
        add(line);
//        line.setFocused(true);
        return ++lines;
    }

    public Line remove(Line line) {
        if (lines == 0) {
            return line;
        }
        children.remove(line);
        lines--;
        return line;
    }

    public String getFirstLine() {
        LinkedElement linkedElement = children.get(0);
        if (linkedElement instanceof Line) {
            return ((Line) linkedElement).getText();
        }
        return "";
    }

    public String getFullText() {
        StringBuilder text = new StringBuilder();
        boolean first = true;
        for (LinkedElement element : children) {
            if (first) {
                first = false;
                continue;
            }
            if (element instanceof Line) {
                Line line = (Line) element;
                text.append(line.getText());
                text.append("\n");
            }
        }
        return text.toString();
    }

    @Override
    public int getX() {
        return rect.getX() + offset.getX();
    }

    @Override
    public int getY() {
        return rect.getY() + offset.getY();
    }

    @Override
    public int width() {
        return rect.width();
    }

    @Override
    public int height() {
        return rect.height();
    }

    public class Line extends LinkedElement {
        private final TextBox box;
        private String text;

        private int cursor = 0;

        private boolean focused = false;

        private int count = 80;

        public Line(String text, TextBox box) {
            this.text = text;
            this.box = box;
        }

        @Override
        public void drawScreen(DrawContext context, int mouseX, int mouseY, float deltaTime) {

            if (focused && count > 0) {
                count--;
            } else {
                count = 80;
            }

            context.drawRect(getX(), getY(), width(), height(), background.getRGB());

            context.drawText(text, getX() + 2, getY() + (height() - font.FONT_HEIGHT) / 2f, Color.white.getRGB());

            if (focused && count < 40)
                context.drawRect(getX() + 2 + font.getStringWidth(text.substring(0, cursor)), getY(), 1, height(), Color.white.getRGB());
        }

        @Override
        public void mouseClicked(int mouseX, int mouseY, int button) {
            if (button != 0) {
                return;
            }

            if (isHovered(mouseX, mouseY)) {
                focused = true;
                targetCursor(mouseX);
            } else {
                focused = false;
            }
        }

        @Override
        public void keyTyped(char character, int keyCode) {
            if (!focused) {
                return;
            }

            if (keyCode == 14) {
                if (text.isEmpty()) {
                    box.remove(this);
                } else {
                    this.remove(cursor - 1);
                }
            } else if (keyCode == 28) {
//                this.setFocused(false);
                box.add();
//                this.setFocused(false);
            } else if (keyCode == Keyboard.KEY_LEFT) {
                if (cursor - 1 >= 0) {
                    cursor--;
                }
            } else if (keyCode == Keyboard.KEY_RIGHT) {
                if (cursor + 1 <= text.length()) {
                    cursor++;
                }
            } else if ((character >= 32 && character <= 127)) {
                this.insert(character, cursor);
            }
        }

        private void targetCursor(int mouseX) {
            int pos = 0;
            int cursor = 0;
            while (cursor < text.length()) {
                String substring = text.substring(cursor, cursor + 1);
                int width = font.getStringWidth(substring);
                if (pos + width <= mouseX) {
                    cursor++;
                    pos += width;
                } else {
                    break;
                }
            }
            this.cursor = cursor;
        }

        public void insert(char c, int pos) {
            if (pos < 0 || pos > text.length()) return;
            text = text.substring(0, pos) + c + text.substring(pos);
            cursor++;
        }

        public void remove(int pos) {
            if (cursor == 0 || pos < 0 || pos >= text.length()) return;
            text = text.substring(0, pos) + text.substring(pos + 1);
            cursor--;
        }

        public Line setFocused(boolean focused) {
            this.focused = focused;
            return this;
        }

        public String getText() {
            return text;
        }

        @Override
        public int getX() {
            return box.getX();
        }

        @Override
        public int getY() {
            return prev.getY() + getHeight();
        }

        @Override
        public int width() {
            return box.width();
        }

        @Override
        public int height() {
            return box.height();
        }
    }
}
