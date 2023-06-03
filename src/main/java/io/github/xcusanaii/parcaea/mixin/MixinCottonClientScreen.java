package io.github.xcusanaii.parcaea.mixin;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.impl.client.MouseInputHandler;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.xcusanaii.parcaea.Parcaea;
import io.github.xcusanaii.parcaea.util.mixin.IScreenParent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CottonClientScreen.class)
public abstract class MixinCottonClientScreen extends Screen implements IScreenParent {

    @Shadow
    protected GuiDescription description;
    @Shadow
    protected int left = 0;
    @Shadow
    protected int top = 0;
    @Shadow
    protected int titleX;
    @Shadow
    protected int titleY;
    @Final
    @Shadow
    private MouseInputHandler<CottonClientScreen> mouseInputHandler;

    private Screen parent = null;
    private int closeSafePadding = Parcaea.CLOSE_SAFE_PADDING;

    protected MixinCottonClientScreen(Text title) {
        super(title);
    }

    @Override
    public void setParent(Screen parent) {
        this.parent = parent;
    }

    @Override
    public Screen getParent() {
        return this.parent;
    }

    @Override
    public void setCloseSafePadding(int padding) {
        this.closeSafePadding = padding;
    }

    @Override
    public int getCloseSafePadding() {
        return this.closeSafePadding;
    }

    /**
     * @author XcusanaIi
     * @reason Close on mouse clicked padding
     */
    @Overwrite
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        int containerX = (int)mouseX-left;
        int containerY = (int)mouseY-top;
        mouseInputHandler.checkFocus(containerX, containerY);
        WPanel root = description.getRootPanel();
        int p = getCloseSafePadding();
        if (root != null && (containerX < -p || containerY < -p || containerX >= root.getWidth() + p || containerY >= root.getHeight() + p)) {
            MinecraftClient.getInstance().setScreen(getParent());
            return true;
        }
        mouseInputHandler.onMouseDown(containerX, containerY, mouseButton);
        return true;
    }

    /**
     * @author XcusanaIi
     * @reason No Gui background
     */
    @Overwrite
    private void paint(MatrixStack matrices, int mouseX, int mouseY) {
//        renderBackground(matrices);
        if (description!=null) {
            WPanel root = description.getRootPanel();
            if (root!=null) {
                GL11.glEnable(GL11.GL_SCISSOR_TEST);
                ScissorsInvoker.invokeRefreshScissors();
                root.paint(matrices, left, top, mouseX-left, mouseY-top);
                GL11.glDisable(GL11.GL_SCISSOR_TEST);
                ScissorsInvoker.invokeCheckStackIsEmpty();
            }
            if (getTitle() != null && description.isTitleVisible()) {
                int width = description.getRootPanel().getWidth();
                ScreenDrawing.drawString(matrices, getTitle().asOrderedText(), description.getTitleAlignment(), left + titleX, top + titleY, width - titleX, description.getTitleColor());
            }
        }
    }

}
