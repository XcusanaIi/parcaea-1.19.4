package io.github.xcusanaii.parcaea.render.hud;

import io.github.xcusanaii.parcaea.model.PInfo;
import io.github.xcusanaii.parcaea.model.label.APLabel;
import io.github.xcusanaii.parcaea.util.math.MathUtil;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.text.DecimalFormat;

import static io.github.xcusanaii.parcaea.Parcaea.MOD_ID;

public class HudRenderHandler implements HudRenderCallback {

    private static final Identifier BG_TEXTURE = new Identifier(MOD_ID, "textures/bg_texture.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

//        int x;
//        int y;
//        MinecraftClient client = MinecraftClient.getInstance();
//        int width = client.getWindow().getScaledWidth();
//        int height = client.getWindow().getScaledHeight();
//        x = width / 2;
//        y = height / 2;
//        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, BG_TEXTURE);
//        DrawableHelper.drawTexture(matrixStack, x, y, 0, 0, 64, 64, 16, 16);

        onRenderTick(MinecraftClient.getInstance(), tickDelta);

        for (APLabel label : APLabel.pLabels) {
            label.onRender(matrixStack);
        }

        renderInfos(matrixStack);
    }

    private void renderInfos(MatrixStack matrixStack) {
        for (PInfo info : PInfo.pInfos) {
            MinecraftClient client = MinecraftClient.getInstance();
            double width = client.getWindow().getScaledWidth();
            double height = client.getWindow().getScaledHeight();
            matrixStack.push();
            matrixStack.scale(info.scale, info.scale, 1.0F);
            int x = (int) (width * info.xPercent / info.scale);
            int y = (int) (height * info.yPercent / info.scale);
            DrawableHelper.drawCenteredTextWithShadow(matrixStack, client.textRenderer, info.info, x, y, info.color);
            matrixStack.pop();
        }
    }

    private void onRenderTick(MinecraftClient client, float tickDelta) {
        if (client.player == null) return;
        APLabel.facing.value = MathUtil.mapFacing(client.player.getYaw(tickDelta));
        APLabel.x.value = client.player.getX();
        APLabel.y.value = client.player.getY();
        APLabel.z.value = client.player.getZ();
    }

}
