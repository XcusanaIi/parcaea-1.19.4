package io.github.xcusanaii.parcaea.model.label;

import io.github.xcusanaii.parcaea.model.config.ModConfig;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.MutableText;

public class PLabelDefault extends APLabel{

    public PLabelDefault(ModConfig.Labels.Label label, MutableText key, Object value) {
        super(label, key, value);
    }

    @Override
    public void onRender(MatrixStack matrixStack) {
        onRenderDefault(matrixStack);
    }
}
