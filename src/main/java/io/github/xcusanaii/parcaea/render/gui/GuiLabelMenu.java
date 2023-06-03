package io.github.xcusanaii.parcaea.render.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WScrollPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class GuiLabelMenu extends GuiNoBackground {

    WButton btnLbX;
    WButton btnLbY;
    WButton btnLbZ;
    WButton btnLbFacing;

    public GuiLabelMenu() {
        MinecraftClient client = MinecraftClient.getInstance();

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(120, client.getWindow().getScaledHeight());
        root.setLocation(5, 5);
        root.setInsets(Insets.ROOT_PANEL);

        WPlainPanel btnList = new WPlainPanel();

        btnLbX = new WButton(Text.translatable("button.parcaea.label_x"));
        btnList.add(btnLbX, 0, 0);

        btnLbY = new WButton(Text.translatable("button.parcaea.label_y"));
        btnList.add(btnLbY, 0, 25);

        btnLbZ = new WButton(Text.translatable("button.parcaea.label_z"));
        btnList.add(btnLbZ, 0, 50);

        btnLbFacing = new WButton(Text.translatable("button.parcaea.label_facing"));
        btnList.add(btnLbFacing, 0, 75);

        btnList.setSize(100, 95);

        WScrollPanel btnListScrollPanel = new WScrollPanel(btnList);

        root.add(btnListScrollPanel, 0, 0);
        btnListScrollPanel.setSize(120, 50);

        root.validate(this);
    }
}
