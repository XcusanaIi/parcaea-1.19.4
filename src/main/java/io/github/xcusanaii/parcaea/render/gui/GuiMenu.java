package io.github.xcusanaii.parcaea.render.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class GuiMenu extends GuiNoBackground{

    public GuiMenu() {
        MinecraftClient client = MinecraftClient.getInstance();

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(100, 60);
        root.setInsets(Insets.ROOT_PANEL);

        WButton btnLabelPosMenu = new WButton(Text.translatable("button.parcaea.label_pos_menu"));
        btnLabelPosMenu.setOnClick(() -> {
            client.setScreen(new CottonClientScreen(new GuiLabelMenu()));
        });
        root.add(btnLabelPosMenu, 0, 0);

        root.validate(this);
    }
}
