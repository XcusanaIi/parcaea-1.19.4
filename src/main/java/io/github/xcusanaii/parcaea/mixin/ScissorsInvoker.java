package io.github.xcusanaii.parcaea.mixin;

import io.github.cottonmc.cotton.gui.client.Scissors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Scissors.class)
public interface ScissorsInvoker {
    @Invoker("refreshScissors")
    static void invokeRefreshScissors() {
        throw new AssertionError();
    }

    @Invoker("checkStackIsEmpty")
    static void invokeCheckStackIsEmpty() {
        throw new AssertionError();
    }
}
