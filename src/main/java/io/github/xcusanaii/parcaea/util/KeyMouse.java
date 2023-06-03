package io.github.xcusanaii.parcaea.util;

import io.github.xcusanaii.parcaea.util.mixin.IKeyGetter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyMouse {
    public static boolean isKeyDown(KeyBinding keyBind) {
        long window = MinecraftClient.getInstance().getWindow().getHandle();
        InputUtil.Key key = ((IKeyGetter) keyBind).getKey();
        if (key.getCategory() == InputUtil.Type.KEYSYM) {
            return GLFW.glfwGetKey(window, key.getCode()) == 1;
        }else if (key.getCategory() == InputUtil.Type.MOUSE) {
            return GLFW.glfwGetMouseButton(window, key.getCode()) == 1;
        }else {
            return false;
        }
    }
}
