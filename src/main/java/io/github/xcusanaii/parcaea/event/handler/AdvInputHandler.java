package io.github.xcusanaii.parcaea.event.handler;

import io.github.xcusanaii.parcaea.Parcaea;
import io.github.xcusanaii.parcaea.model.KeyBinds;
import io.github.xcusanaii.parcaea.model.PInfo;
import io.github.xcusanaii.parcaea.util.mixin.IKeyGetter;
import io.github.xcusanaii.parcaea.util.KeyMouse;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class AdvInputHandler {

    private static boolean invertSprint = false;

    private static int sprintKeyCodePre = 0;

    public void onClientTickStart(MinecraftClient client) {
        KeyBinding sprintKey = client.options.sprintKey;
        if (KeyBinds.keyToggleInvertSprint.wasPressed()) {
            while (KeyBinds.keyToggleInvertSprint.wasPressed()) {}
            InputUtil.Key key = ((IKeyGetter) sprintKey).getKey();
            invertSprint = !invertSprint;
            if (invertSprint) {
                sprintKeyCodePre = key.getCode();
                client.options.setKeyCode(sprintKey, InputUtil.Type.MOUSE.createFromCode(KeyBinds.keyBindSprintMap));
                client.options.setKeyCode(KeyBinds.keyInvertSprint, InputUtil.Type.KEYSYM.createFromCode(sprintKeyCodePre));
                sprintKey.setPressed(true);
            }else {
                client.options.setKeyCode(sprintKey, InputUtil.Type.KEYSYM.createFromCode(sprintKeyCodePre));
                client.options.setKeyCode(KeyBinds.keyInvertSprint, InputUtil.Type.KEYSYM.createFromCode(GLFW.GLFW_KEY_UNKNOWN));
                sprintKey.setPressed(false);
            }
            PInfo.pInfos.add(new PInfo(
                    0.5D,
                    0.8D,
                    2.0F,
                    invertSprint ? Parcaea.getConfig().colorGeneral.themeColor : Parcaea.getConfig().colorGeneral.white,
                    20,
                    Text.translatable("message.parcaea.invert_sprint")
                    )
            );
        }
        if (invertSprint) {
            sprintKey.setPressed(!KeyMouse.isKeyDown(KeyBinds.keyInvertSprint));
        }
    }
}
