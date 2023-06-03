package io.github.xcusanaii.parcaea.mixin;

import io.github.xcusanaii.parcaea.util.mixin.IKeyGetter;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(KeyBinding.class)
public abstract class MixinKeyBinding implements IKeyGetter {
    @Shadow
    private InputUtil.Key boundKey;

    @Override
    public InputUtil.Key getKey() {
        return boundKey;
    }
}
