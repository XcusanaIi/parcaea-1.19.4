package io.github.xcusanaii.parcaea.render.gui;

import io.github.xcusanaii.parcaea.Parcaea;
import io.github.xcusanaii.parcaea.render.gui.widget.PButton;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class GuiVanillaTest extends Screen {

    PButton btnTest;

    public GuiVanillaTest(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        btnTest = new PButton(50, 50, 150, 20,
                Text.literal("Hello"),
                button -> Parcaea.LOGGER.info("btn clicked!"),
                textSupplier -> Text.literal("Hello")
        );

        addDrawableChild(btnTest);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
    }
}
