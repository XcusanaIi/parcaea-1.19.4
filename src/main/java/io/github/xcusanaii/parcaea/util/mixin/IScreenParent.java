package io.github.xcusanaii.parcaea.util.mixin;

import net.minecraft.client.gui.screen.Screen;

public interface IScreenParent {
    void setParent(Screen parent);
    Screen getParent();
    void setCloseSafePadding(int padding);
    int getCloseSafePadding();
}
