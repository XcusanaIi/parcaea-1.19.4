package io.github.xcusanaii.parcaea;

import io.github.xcusanaii.parcaea.event.TickHandler;
import io.github.xcusanaii.parcaea.model.KeyBinds;
import io.github.xcusanaii.parcaea.render.hud.HudRenderHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class ParcaeaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinds.registerKeyBinds();
        TickHandler.registerTickHandler();
        HudRenderCallback.EVENT.register(new HudRenderHandler());
    }
}
