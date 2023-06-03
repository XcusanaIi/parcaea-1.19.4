package io.github.xcusanaii.parcaea.event.handler;

import io.github.xcusanaii.parcaea.model.PInfo;
import net.minecraft.client.MinecraftClient;

public class PInfoHandler {
    public void onClientTickStart(MinecraftClient client) {
        for (PInfo pInfo : PInfo.pInfos) {
            pInfo.life--;
        }
        PInfo.pInfos.removeIf(pInfo -> pInfo.life <= 0);
    }
}
