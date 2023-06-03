package io.github.xcusanaii.parcaea.model;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {

    public static final String CATEGORY = "key.category.parcaea";

    public static final int keyBindSprintMap = GLFW.GLFW_MOUSE_BUTTON_8;

    public static final KeyBinding keyTest = new KeyBinding("key.parcaea.test", GLFW.GLFW_KEY_UNKNOWN, CATEGORY);
    public static final KeyBinding keyToggleInvertSprint = new KeyBinding("key.parcaea.toggle_invert_sprint", GLFW.GLFW_KEY_X, CATEGORY);
    public static final KeyBinding keyInvertSprint = new KeyBinding("key.parcaea.invert_sprint", GLFW.GLFW_KEY_UNKNOWN, CATEGORY);
    public static final KeyBinding keyMenu = new KeyBinding("key.parcaea.menu", GLFW.GLFW_KEY_Z, CATEGORY);
    public static final KeyBinding keyToggleAllLabels = new KeyBinding("key.parcaea.toggle_all_labels", InputUtil.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_4, CATEGORY);

    public static void registerKeyBinds() {
        KeyBindingHelper.registerKeyBinding(keyTest);
        KeyBindingHelper.registerKeyBinding(keyToggleInvertSprint);
        KeyBindingHelper.registerKeyBinding(keyInvertSprint);
        KeyBindingHelper.registerKeyBinding(keyMenu);
        KeyBindingHelper.registerKeyBinding(keyToggleAllLabels);
    }

}
