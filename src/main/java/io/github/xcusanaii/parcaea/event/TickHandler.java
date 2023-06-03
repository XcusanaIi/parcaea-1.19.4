package io.github.xcusanaii.parcaea.event;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.xcusanaii.parcaea.event.handler.AdvInputHandler;
import io.github.xcusanaii.parcaea.event.handler.PInfoHandler;
import io.github.xcusanaii.parcaea.model.KeyBinds;
import io.github.xcusanaii.parcaea.render.gui.GuiMenu;
import io.github.xcusanaii.parcaea.render.gui.GuiVanillaTest;
import io.github.xcusanaii.parcaea.render.gui.ModConfigMenu;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class TickHandler {

    private static final PInfoHandler pInfoHandler = new PInfoHandler();
    private static final AdvInputHandler advInputHandler = new AdvInputHandler();

    public static boolean disableAllLabels = false;

    private static void onClientTickStart(MinecraftClient client) {
        advInputHandler.onClientTickStart(client);
        pInfoHandler.onClientTickStart(client);
        if (KeyBinds.keyTest.wasPressed()) {
            while (KeyBinds.keyTest.wasPressed()) {}
//            client.setScreen(new GuiVanillaTest(Text.literal("title")));
        }
        if (KeyBinds.keyMenu.wasPressed()) {
            while (KeyBinds.keyMenu.wasPressed()) {}
            client.setScreen(ModConfigMenu.getScreen(null));
        }
        if (KeyBinds.keyToggleAllLabels.wasPressed()) {
            while (KeyBinds.keyToggleAllLabels.wasPressed()) {}
            disableAllLabels = !disableAllLabels;
        }
    }

    public static void registerTickHandler() {
        ClientTickEvents.START_CLIENT_TICK.register(TickHandler::onClientTickStart);
    }
}
