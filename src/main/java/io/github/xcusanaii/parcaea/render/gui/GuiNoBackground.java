package io.github.xcusanaii.parcaea.render.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

public class GuiNoBackground extends LightweightGuiDescription {
    @Override
    public void addPainters() {
        if (this.rootPanel!=null && !fullscreen) {
            this.rootPanel.setBackgroundPainter(null);
        }
    }
}
