package io.github.xcusanaii.parcaea.model.label;

import io.github.xcusanaii.parcaea.Parcaea;
import io.github.xcusanaii.parcaea.event.TickHandler;
import io.github.xcusanaii.parcaea.model.config.ModConfig;
import io.github.xcusanaii.parcaea.util.math.MathUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class APLabel {

    public static List<APLabel> pLabels = new ArrayList<>();

    public static APLabel x;
    public static APLabel y;
    public static APLabel z;
    public static APLabel facing;

    public static void init() {
        ModConfig.Labels labels = Parcaea.getConfig().labels;
        x = new PLabelDefault(labels.x, Text.translatable("label.parcaea.x"), 0.0);
        y = new PLabelDefault(labels.y, Text.translatable("label.parcaea.y"), 0.0);
        z = new PLabelDefault(labels.z, Text.translatable("label.parcaea.z"), 0.0);
        facing = new APLabel(labels.facing, Text.translatable("label.parcaea.facing"), 0.0) {
            @Override
            public void onRender(MatrixStack matrixStack) {
                boolean visible = !TickHandler.disableAllLabels && this.visible;
                if (!visible) return;
                ModConfig config = Parcaea.getConfig();
                boolean bl = config.cfgGeneral.enGlobalLabelConfig;
                float scale = bl ? config.globalLabel.scale : this.scale;
                int colorKey = bl ? config.globalLabel.colorKey : this.colorKey;
                int colorValue = bl ? config.globalLabel.colorValue : this.colorValue;
                int decimalCount = bl ? config.globalLabel.decimalCount : this.decimalCount;
                MinecraftClient client = MinecraftClient.getInstance();
                matrixStack.push();
                matrixStack.scale(scale, scale, 1.0F);
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, this.key.getString() + ":", this.posX, this.posY, colorKey);
                int spaceBarWidth = client.textRenderer.getWidth(": ");
                int offsetX = client.textRenderer.getWidth(this.key) + spaceBarWidth;
                String str;
                if (this.value instanceof Number) {
                    DecimalFormat decimalFormat = new DecimalFormat("#." + "#".repeat(decimalCount));
                    decimalFormat.setMinimumFractionDigits(decimalCount);
                    str = decimalFormat.format(this.value);
                }else {
                    str = this.value.toString();
                }
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, str, this.posX + offsetX, this.posY, colorValue);
                offsetX += client.textRenderer.getWidth(str + " ");
                String facing = MathUtil.getFacingEnum(((Double) this.value)) == MathUtil.Facing.X ? "X" : "Z";
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, facing, this.posX + offsetX, this.posY, colorKey);
                matrixStack.pop();
            }
        };

        pLabels.add(x);
        pLabels.add(y);
        pLabels.add(z);
        pLabels.add(facing);
    }

    public static void reloadLabelsFromConfig() {
        ModConfig.Labels labels = Parcaea.getConfig().labels;
        x.reloadProperty(labels.x);
        y.reloadProperty(labels.y);
        z.reloadProperty(labels.z);
        facing.reloadProperty(labels.facing);
    }

    public int posX;
    public int posY;
    public float scale;
    public int colorKey;
    public int colorValue;
    public final MutableText key;
    public Object value;
    public boolean visible;
    public int decimalCount;

    public APLabel(ModConfig.Labels.Label label, MutableText key, Object value) {
        this.posX = label.posX;
        this.posY = label.posY;
        this.scale = label.scale;
        this.colorKey = label.colorKey;
        this.colorValue = label.colorValue;
        this.key = key;
        this.value = value;
        this.visible = label.visible;
        this.decimalCount = label.decimalCount;
    }

    public void reloadProperty(ModConfig.Labels.Label label) {
        this.posX = label.posX;
        this.posY = label.posY;
        this.scale = label.scale;
        this.colorKey = label.colorKey;
        this.colorValue = label.colorValue;
        this.visible = label.visible;
        this.decimalCount = label.decimalCount;
    }

    public abstract void onRender(MatrixStack matrixStack);

    protected void onRenderDefault(MatrixStack matrixStack) {
        boolean visible = !TickHandler.disableAllLabels && this.visible;
        if (!visible) return;
        ModConfig config = Parcaea.getConfig();
        boolean bl = config.cfgGeneral.enGlobalLabelConfig;
        float scale = bl ? config.globalLabel.scale : this.scale;
        int colorKey = bl ? config.globalLabel.colorKey : this.colorKey;
        int colorValue = bl ? config.globalLabel.colorValue : this.colorValue;
        int decimalCount = bl ? config.globalLabel.decimalCount : this.decimalCount;
        MinecraftClient client = MinecraftClient.getInstance();
        matrixStack.push();
        matrixStack.scale(scale, scale, 1.0F);
        DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, this.key.getString() + ":", this.posX, this.posY, colorKey);
        int offsetX = client.textRenderer.getWidth(this.key);
        int spaceBarWidth = client.textRenderer.getWidth(": ");
        String str;
        if (this.value instanceof Number) {
            DecimalFormat decimalFormat = new DecimalFormat("#." + "#".repeat(decimalCount));
            decimalFormat.setMinimumFractionDigits(decimalCount);
            str = decimalFormat.format(this.value);
        }else {
            str = this.value.toString();
        }
        DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, str, this.posX + offsetX + spaceBarWidth, this.posY, colorValue);
        matrixStack.pop();
    }
}
