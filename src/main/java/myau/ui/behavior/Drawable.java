package myau.ui.behavior;

import myau.ui.DrawContext;

// 实现这个接口来进行当前类的绘制
// 对于一些特殊类，比如 DraggableLinkedElement
// 需要将位置更新置顶在 drawScreen 方法时很有用
public interface Drawable {

    default void render(DrawContext context, int mouseX, int mouseY, float deltaTime) {}

}
