package io.github.xcusanaii.parcaea;

import io.github.xcusanaii.parcaea.model.config.ModConfig;
import io.github.xcusanaii.parcaea.model.label.APLabel;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parcaea implements ModInitializer {

    public static final String MOD_ID = "parcaea";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final int CLOSE_SAFE_PADDING = 10;

    private static ConfigHolder<ModConfig> configHolder;

    public static ModConfig getConfig() {
        return configHolder.getConfig();
    }

    public static void saveConfig() {
        configHolder.save();
    }

    @Override
    public void onInitialize() {
        configHolder = AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        APLabel.init();
    }
}
