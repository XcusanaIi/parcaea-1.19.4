package io.github.xcusanaii.parcaea.mixin;

import io.github.xcusanaii.parcaea.Parcaea;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient {
    @Shadow
    @Final
    public GameOptions options;

    @Inject(method = "close", at = @At("HEAD"))
    private void saveOnClose(CallbackInfo info) {
        options.write();
        Parcaea.saveConfig();
    }
}
